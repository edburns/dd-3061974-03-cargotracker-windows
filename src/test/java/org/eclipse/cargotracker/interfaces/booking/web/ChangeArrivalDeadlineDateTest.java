package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.Location;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.RouteCandidate;
import org.junit.Test;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

public class ChangeArrivalDeadlineDateTest {

    private ChangeArrivalDeadlineDate createBean(BookingServiceFacade facade)
            throws Exception {
        ChangeArrivalDeadlineDate bean = new ChangeArrivalDeadlineDate();
        Field field = ChangeArrivalDeadlineDate.class
                .getDeclaredField("bookingServiceFacade");
        field.setAccessible(true);
        field.set(bean, facade);
        return bean;
    }

    @Test
    public void loadsCargoForTheSelectedTrackingIdAndConvertsTheDeadline()
            throws Exception {
        Date deadline = new SimpleDateFormat("MM/dd/yyyy").parse("03/15/2019");
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(
                new CargoRoute("ABC123", "USNYC", "SESTO", deadline, false,
                        false, "USNYC", "IN_PORT"));
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");

        bean.load();

        assertEquals("ABC123", facade.loadedTrackingId);
        assertSame(facade.cargo, bean.getCargo());
        assertEquals(deadline, bean.getArrivalDeadlineDate());
    }

    @Test
    public void delegatesSelectedDeadlineAndTrackingIdOnSubmission()
            throws Exception {
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(null);
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");
        Date selected = new SimpleDateFormat("MM/dd/yyyy").parse("04/20/2019");
        bean.setArrivalDeadlineDate(selected);

        try {
            bean.changeArrivalDeadline();
        } catch (Exception expectedOutsideOfAContainer) {
            // Closing the dynamic dialog requires a JSF context.
        }

        assertEquals("ABC123", facade.changedTrackingId);
        assertSame(selected, facade.changedDeadline);
        assertEquals(1, facade.changeDeadlineCallCount);
    }

    @Test
    public void surfacesMalformedDeadlineInsteadOfConvertingItToNull()
            throws Exception {
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(
                new CargoRouteWithDeadline("03/15/2019junk"));
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");

        try {
            bean.load();
            fail("Expected the malformed deadline to be surfaced.");
        } catch (RuntimeException expected) {
            assertNull(bean.getArrivalDeadlineDate());
        }
    }

    @Test
    public void rejectsANonexistentCalendarDate() throws Exception {
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(
                new CargoRouteWithDeadline("02/30/2019 00:00:00"));
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");

        try {
            bean.load();
            fail("Expected the invalid calendar date to be surfaced.");
        } catch (RuntimeException expected) {
            assertNull(bean.getArrivalDeadlineDate());
        }
    }

    @Test
    public void rejectsANullSelectedDeadlineWithoutDelegating()
            throws Exception {
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(null);
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");

        try {
            bean.changeArrivalDeadline();
            fail("Expected the null deadline to be rejected.");
        } catch (IllegalStateException expected) {
            assertEquals(0, facade.changeDeadlineCallCount);
        }
    }

    @Test
    public void doesNotCloseTheDialogWhenSubmissionFails() throws Exception {
        FakeBookingServiceFacade facade = new FakeBookingServiceFacade(null);
        facade.failOnChangeDeadline = true;
        ChangeArrivalDeadlineDate bean = createBean(facade);
        bean.setTrackingId("ABC123");
        bean.setArrivalDeadlineDate(
                new SimpleDateFormat("MM/dd/yyyy").parse("04/20/2019"));

        try {
            bean.changeArrivalDeadline();
            fail("Expected the facade failure to be surfaced.");
        } catch (IllegalArgumentException expected) {
            assertEquals(1, facade.changeDeadlineCallCount);
        }
    }

    private static class CargoRouteWithDeadline extends CargoRoute {
        private static final long serialVersionUID = 1L;
        private final String deadline;

        CargoRouteWithDeadline(String deadline) {
            super("ABC123", "USNYC", "SESTO", new Date(), false, false,
                    "USNYC", "IN_PORT");
            this.deadline = deadline;
        }

        @Override
        public String getArrivalDeadline() {
            return deadline;
        }
    }

    private static class FakeBookingServiceFacade
            implements BookingServiceFacade {

        private final CargoRoute cargo;
        private String loadedTrackingId;
        private String changedTrackingId;
        private Date changedDeadline;
        private int changeDeadlineCallCount;
        private boolean failOnChangeDeadline;

        FakeBookingServiceFacade(CargoRoute cargo) {
            this.cargo = cargo;
        }

        @Override
        public String bookNewCargo(String origin, String destination,
                                   Date arrivalDeadline) {
            return null;
        }

        @Override
        public CargoRoute loadCargoForRouting(String trackingId) {
            this.loadedTrackingId = trackingId;
            return cargo;
        }

        @Override
        public void assignCargoToRoute(String trackingId,
                                       RouteCandidate route) {
        }

        @Override
        public void changeDestination(String trackingId,
                                      String destinationUnLocode) {
        }

        @Override
        public void changeDeadline(String trackingId, Date arrivalDeadline) {
            this.changedTrackingId = trackingId;
            this.changedDeadline = arrivalDeadline;
            this.changeDeadlineCallCount++;

            if (failOnChangeDeadline) {
                throw new IllegalArgumentException("Deadline change failed.");
            }
        }

        @Override
        public List<RouteCandidate> requestPossibleRoutesForCargo(
                String trackingId) {
            return null;
        }

        @Override
        public List<Location> listShippingLocations() {
            return null;
        }

        @Override
        public List<CargoRoute> listAllCargos() {
            return null;
        }
    }
}

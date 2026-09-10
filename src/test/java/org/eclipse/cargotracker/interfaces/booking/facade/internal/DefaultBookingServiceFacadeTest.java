package org.eclipse.cargotracker.interfaces.booking.facade.internal;

import org.eclipse.cargotracker.application.BookingService;
import org.eclipse.cargotracker.domain.model.cargo.Itinerary;
import org.eclipse.cargotracker.domain.model.cargo.TrackingId;
import org.eclipse.cargotracker.domain.model.location.UnLocode;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class DefaultBookingServiceFacadeTest {

    @Test
    public void delegatesDeadlineChangeWithConvertedTrackingId() throws Exception {
        DeadlineChangeSpy bookingService = new DeadlineChangeSpy();
        DefaultBookingServiceFacade facade = new DefaultBookingServiceFacade();
        Field field = DefaultBookingServiceFacade.class
                .getDeclaredField("bookingService");
        field.setAccessible(true);
        field.set(facade, bookingService);
        Date deadline = new Date();

        facade.changeDeadline("ABC123", deadline);

        assertEquals(new TrackingId("ABC123"), bookingService.trackingId);
        assertSame(deadline, bookingService.deadline);
        assertEquals(1, bookingService.callCount);
    }

    private static class DeadlineChangeSpy implements BookingService {
        private TrackingId trackingId;
        private Date deadline;
        private int callCount;

        @Override
        public TrackingId bookNewCargo(UnLocode origin, UnLocode destination,
                                       Date arrivalDeadline) {
            return null;
        }

        @Override
        public List<Itinerary> requestPossibleRoutesForCargo(
                TrackingId trackingId) {
            return null;
        }

        @Override
        public void assignCargoToRoute(Itinerary itinerary,
                                       TrackingId trackingId) {
        }

        @Override
        public void changeDestination(TrackingId trackingId,
                                      UnLocode unLocode) {
        }

        @Override
        public void changeDeadline(TrackingId trackingId, Date deadline) {
            this.trackingId = trackingId;
            this.deadline = deadline;
            callCount++;
        }
    }
}

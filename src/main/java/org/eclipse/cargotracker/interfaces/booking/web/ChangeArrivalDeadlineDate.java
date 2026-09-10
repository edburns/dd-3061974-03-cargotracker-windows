package org.eclipse.cargotracker.interfaces.booking.web;

import org.eclipse.cargotracker.interfaces.booking.facade.BookingServiceFacade;
import org.eclipse.cargotracker.interfaces.booking.facade.dto.CargoRoute;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Handles changing the cargo arrival deadline. Operates against a dedicated
 * service facade, just like the change destination user interface, so the
 * domain layer stays shielded from user interface considerations.
 */
@Named
@ViewScoped
public class ChangeArrivalDeadlineDate implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String DATE_FORMAT = "MM/dd/yyyy";

    private String trackingId;
    private CargoRoute cargo;
    @NotNull
    private Date arrivalDeadlineDate;
    @Inject
    private BookingServiceFacade bookingServiceFacade;

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public CargoRoute getCargo() {
        return cargo;
    }

    public Date getArrivalDeadlineDate() {
        return arrivalDeadlineDate;
    }

    public void setArrivalDeadlineDate(Date arrivalDeadlineDate) {
        this.arrivalDeadlineDate = arrivalDeadlineDate;
    }

    public void load() {
        cargo = bookingServiceFacade.loadCargoForRouting(trackingId);

        try {
            String formattedDeadline = cargo.getArrivalDeadline();
            int separator = formattedDeadline.indexOf(' ');
            String datePortion = separator < 0
                    ? formattedDeadline : formattedDeadline.substring(0,
                            separator);
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
            formatter.setLenient(false);
            ParsePosition position = new ParsePosition(0);
            arrivalDeadlineDate = formatter.parse(datePortion, position);
            if (arrivalDeadlineDate == null
                    || position.getIndex() != datePortion.length()) {
                throw new ParseException("Invalid arrival deadline",
                        position.getErrorIndex());
            }
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing date", e);
        }
    }

    public void changeArrivalDeadline() {
        if (arrivalDeadlineDate == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            if (context != null) {
                context.addMessage(null, new FacesMessage(
                        FacesMessage.SEVERITY_ERROR,
                        "An arrival deadline date must be selected.", null));
                context.validationFailed();
                return;
            }
            throw new IllegalStateException(
                    "An arrival deadline date must be selected.");
        }

        bookingServiceFacade.changeDeadline(trackingId, arrivalDeadlineDate);

        PrimeFaces.current().dialog().closeDynamic("DONE");
    }
}

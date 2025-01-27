package ch.noseryoung.backend_team7.domain.reservation;

/**
 * Exception thrown when a reservation is attempted on a table that is already reserved.
 *
 * <p>This exception is used to indicate that the table specified in the reservation request
 * is unavailable because it has already been booked.</p>
 */
public class TableAlreadyReservedException extends Exception {

    /**
     * Constructs a new {@code TableAlreadyReservedException} with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

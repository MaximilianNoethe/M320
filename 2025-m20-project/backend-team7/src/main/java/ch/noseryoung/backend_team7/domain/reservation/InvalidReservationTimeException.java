package ch.noseryoung.backend_team7.domain.reservation;

/**
 * Exception thrown when an invalid reservation time is encountered.
 */
public class InvalidReservationTimeException extends Exception {

    /**
     * Constructs a new InvalidReservationTimeException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception.
     */
    public InvalidReservationTimeException(String message) {
        super(message);
    }
}

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The Flight class represents a flight with a flight number, departure date and time,
 * and a list of passengers.
 */
public class Flight {
    private String flightNumber;
    private LocalDateTime departureDateTime;
    private ArrayList<Passenger> passengers;

    /**
     * Constructs a Flight object with a  flight number and departure date/time.
     *
     * @param flightNumber      The flight number.
     * @param departureDateTime The departure date and time of the flight.
     */
    public Flight(String flightNumber, LocalDateTime departureDateTime) {
        this.flightNumber = flightNumber;
        this.departureDateTime = departureDateTime;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    /**
     * Adds a passenger to the passenger list.
     *
     * @param passenger The Passenger object to be added to the flight.
     */
    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    /**
     * Prints the list of passengers on the flight with the corresponding flight details.
     */
    public void printPassengerList() {
        System.out.println("\nFlight Number: " + flightNumber);
        System.out.println("Departure Date and Time: " + departureDateTime);
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName());
        }
    }
}

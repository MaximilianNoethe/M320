import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The Schedule class manages a collection of flights, allowing users to add, search and display flight details.
 */
public class Schedule {
    private ArrayList<Flight> flights;

    public Schedule() {
        flights = new ArrayList<>();
    }

    /**
     * Adds a flight to the schedule.
     *
     * @param flight The Flight object to be added to the schedule.
     */
    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Finds a flight in the schedule based on its flight number and departure date/time.
     *
     * @param flightNumber The flight number to search for.
     * @param dateTime     The LocalDateTime of the flight's departure.
     * @return The matching Flight object if found; otherwise, null.
     */
    public Flight findFlight(String flightNumber, LocalDateTime dateTime) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber) &&
                    flight.getDepartureDateTime().equals(dateTime)) {
                return flight;
            }
        }
        return null;
    }

    /**
     * Prints all flights in the schedule to the console.
     * Each flight displays their flight number and departure time.
     */
    public void printAllFlights() {
        System.out.println("\n--- Flight Schedule ---");
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Departure: " + flight.getDepartureDateTime());
            System.out.println("------------------------");
        }
    }
}

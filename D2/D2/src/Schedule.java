import java.time.LocalDateTime;
import java.util.ArrayList;

public class Schedule {
    private ArrayList<Flight> flights;

    public Schedule() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlight(String flightNumber, LocalDateTime dateTime) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber) &&
                    flight.getDepartureDateTime().equals(dateTime)) {
                return flight;
            }
        }
        return null;
    }

    public void printAllFlights() {
        System.out.println("\n--- Flight Schedule ---");
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("Departure: " + flight.getDepartureDateTime());
            System.out.println("------------------------");
        }
    }
}

import java.util.ArrayList;

public class Schedule {
    private ArrayList<Flight> flights;

    public Schedule() {
        flights = new ArrayList<>();
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight getFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                return flight;
            }
        }
        return null;
    }

    public void printFlights() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            System.out.println("Available flights:");
            for (Flight flight : flights) {
                System.out.println("- Flight " + flight.getFlightNumber());
            }
        }
    }
}

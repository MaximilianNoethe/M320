import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private LocalDateTime departureDateTime;
    private ArrayList<Passenger> passengers;

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

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void printPassengerList() {
        System.out.println("\nFlight Number: " + flightNumber);
        System.out.println("Departure Date and Time: " + departureDateTime);
        System.out.println("Passenger List:");
        for (Passenger passenger : passengers) {
            System.out.println("- " + passenger.getName());
        }
    }
}

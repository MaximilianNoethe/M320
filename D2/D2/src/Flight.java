import java.util.ArrayList;

public class Flight {
    private String flightNumber;
    private ArrayList<Passenger> passengers;

    public Flight(String flightNumber) {
        this.flightNumber = flightNumber;
        this.passengers = new ArrayList<>();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public void printPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No Passengers on flight " + flightNumber);
        } else {
            System.out.println("Passengers on flight " + flightNumber + ":");
            for (Passenger passenger : passengers) {
                System.out.println("- " + passenger);
            }

        }
    }
}

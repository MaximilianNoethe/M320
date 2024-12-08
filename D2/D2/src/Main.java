import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();

        schedule.addFlight(new Flight("AB123"));
        schedule.addFlight(new Flight("CD456"));

        while (true) {
            System.out.println("Menu:\n" +
                    "1. Add a Passenger to a Flight\n" +
                    "2. Print Passengers of a Flight\n" +
                    "3. Print Available Flights\n" +
                    "4. Exit\n" +
                    "Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter flight number: ");
                    String flightNumber = scanner.nextLine();
                    Flight flight = schedule.getFlight(flightNumber);

                    if (flight != null) {
                        System.out.println("Enter passenger name: ");
                        String passengerName = scanner.nextLine();
                        Passenger passenger = new Passenger(passengerName);
                        flight.addPassenger(passenger);
                        System.out.println("Passenger with name " + passengerName + " added to flight " + flightNumber + ".");
                    } else {
                        System.out.println("Flight " + flightNumber + " does not exist.");
                    }
                    break;

                case 2:
                    System.out.println("Enter Flight number: ");
                    flightNumber = scanner.nextLine();
                    flight = schedule.getFlight(flightNumber);

                    if (flight != null) {
                        flight.printPassengers();
                    } else {
                        System.out.println("Flight " + flightNumber + " does not exist,");
                    }
                    break;

                case 3:
                    schedule.printFlights();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid input. Please try again.");
            }

        }
    }
}
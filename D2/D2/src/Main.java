import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Schedule schedule = new Schedule();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


        while (true) {
            System.out.println("\n--- Flight Management System ---");
            System.out.println("1. Add a new flight");
            System.out.println("2. Register a passenger for a flight");
            System.out.println("3. Display all flights");
            System.out.println("4. Display passenger list for a flight");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter flight number: ");
                    String flightNumber = scanner.nextLine();

                    System.out.print("Enter departure date and time (yyyy-MM-dd HH:mm): ");
                    String dateTimeInput = scanner.nextLine();
                    LocalDateTime departureDateTime = LocalDateTime.parse(dateTimeInput, formatter);

                    Flight newFlight = new Flight(flightNumber, departureDateTime);
                    schedule.addFlight(newFlight);
                    System.out.println("Flight added successfully!");
                    break;

                case 2:
                    System.out.print("Enter flight number: ");
                    String flightNum = scanner.nextLine();

                    System.out.print("Enter departure date and time (yyyy-MM-dd HH:mm): ");
                    String dateTime = scanner.nextLine();
                    LocalDateTime dateTimeParsed = LocalDateTime.parse(dateTime, formatter);

                    Flight flight = schedule.findFlight(flightNum, dateTimeParsed);
                    if (flight != null) {
                        System.out.print("Enter passenger name: ");
                        String passengerName = scanner.nextLine();
                        flight.addPassenger(new Passenger(passengerName));
                        System.out.println("Passenger added successfully!");
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                case 3:
                    schedule.printAllFlights();
                    break;

                case 4:
                    System.out.print("Enter flight number: ");
                    String flightNo = scanner.nextLine();

                    System.out.print("Enter departure date and time (yyyy-MM-dd HH:mm): ");
                    String flightDateTime = scanner.nextLine();
                    LocalDateTime flightDT = LocalDateTime.parse(flightDateTime, formatter);

                    Flight foundFlight = schedule.findFlight(flightNo, flightDT);
                    if (foundFlight != null) {
                        foundFlight.printPassengerList();
                    } else {
                        System.out.println("Flight not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
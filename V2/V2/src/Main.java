import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        MediaManager mediaManager = new MediaManager();
        Scanner scanner = new Scanner(System.in);

        mediaManager.addMedia(new Book("The Catcher in the Rye", "Penguin", "J.D. Salinger"));
        mediaManager.addMedia(new Magazine("National Geographic", "National Geographic Society", 1234));


        /*
        // Adding objects for each subclass to the list
        people.add(new Direktor("Dr. Schmidt", 1975, "123 School St.", "Office-101"));
        people.add(new Sekretaerin("Frau Müller", 1985, "456 Office Ave.", 80));
        people.add(new Schueler("Max Mustermann", 2005, "789 Student Rd.", "Grade 10"));
        people.add(new Lehrer("Herr Fischer", 1980, "321 Teacher Ln.", "Mathematics"));
        people.add(new Sozialarbeiter("Herr Becker", 1990, "654 Care Blvd.", 25));

        // Display information for all elements in the list
        System.out.println("School Hierarchy Details:");
        for (Person person : people) {
            person.displayInfo();
            System.out.println("------------------------");
        }*/
        while (true) {
            System.out.println("--- Media Manager ---");
            System.out.println("1. Display all media");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            String input = scanner.nextLine();
            int choice;

            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number (1 or 2).\n");
                continue;
            }


            switch (choice) {
                case 1:
                    mediaManager.printAllMedia();

                    break;

                case 2:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        }
    }
}

import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

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
        }
    }
}

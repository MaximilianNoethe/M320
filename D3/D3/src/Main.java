import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Attraktionen erstellen
        Attraktion achterbahn = new Attraktion("Achterbahn", 12, 120.0);
        Attraktion freifallturm = new Attraktion("Freifallturm", 14, 100.0);
        Attraktion wasserbahn = new Attraktion("Wasserbahn", 8, 200.0);

        // Benutzeroberfläche
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Willkommen im Freizeitpark-Buchungssystem!");
            System.out.println("Verfügbare Attraktionen:");
            System.out.println("1. Achterbahn");
            System.out.println("2. Freifallturm");
            System.out.println("3. Wasserbahn");
            System.out.println("4. Beenden");

            System.out.print("Bitte wählen Sie eine Attraktion (1-4): ");
            int wahl = scanner.nextInt();

            if (wahl == 4) {
                System.out.println("Vielen Dank für Ihren Besuch! Auf Wiedersehen.");
                break;
            }

            Attraktion ausgewaehlteAttraktion = null;
            switch (wahl) {
                case 1 -> ausgewaehlteAttraktion = achterbahn;
                case 2 -> ausgewaehlteAttraktion = freifallturm;
                case 3 -> ausgewaehlteAttraktion = wasserbahn;
                default -> {
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut.");
                    continue;
                }
            }

            System.out.print("Bitte geben Sie Ihr Alter ein: ");
            int alter = scanner.nextInt();

            System.out.print("Bitte geben Sie Ihr Gewicht ein (in kg): ");
            double gewicht = scanner.nextDouble();

            try {
                assert ausgewaehlteAttraktion != null;
                ausgewaehlteAttraktion.pruefer(alter, gewicht);
                System.out.println("Buchung erfolgreich! Viel Spaß bei der Attraktion " + ausgewaehlteAttraktion.getName() + "!");
            } catch (UngueltigesAlterException | UngueltigesGewichtException e) {
                System.out.println("Buchung fehlgeschlagen: " + e.getMessage());
            }

            System.out.println("-----------------------------");
        }

        scanner.close();
    }
}
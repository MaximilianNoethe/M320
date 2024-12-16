public class Main {
    public static void main(String[] args) {
        Figur[] figuren = {
                new AxtKrieger("Krieger Axel"),
                new DolchKrieger("Krieger Dario"),
                new AxtMagier("Magier Aria"),
                new StabMagier("Magier Stellan"),
                new DolchMagier("Magier Delia"),
                new AxtSchurke("Schurke Arvid"),
                new DolchSchurke("Schurke Dorian")
        };

        for (Figur figur : figuren) {
            System.out.println("Figur: " + figur.getCharacterName());
            figur.laufen();
            figur.kaempfen();
            System.out.println("-----------------------");
        }
    }
}
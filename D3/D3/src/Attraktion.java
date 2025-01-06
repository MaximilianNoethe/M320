public class Attraktion { // Attraktion -> Attraction in english i.e. a rollercoaster
    private String name;
    private int mindestalter;
    private double maxGewicht;

    public Attraktion(String name, int mindestalter, double maxGewicht) {
        this.name = name;
        this.mindestalter = mindestalter;
        this.maxGewicht = maxGewicht;
    }

    public String getName() {
        return name;
    }

    public void pruefer(int alter, double gewicht) throws UngueltigesAlterException, UngueltigesGewichtException {
        Validator.validateAlter(alter, mindestalter);
        Validator.validateGewicht(gewicht, maxGewicht);
    }
}
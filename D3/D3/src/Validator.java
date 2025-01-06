class Validator {
    public static void validateAlter(int alter, int mindestalter) throws UngueltigesAlterException {
        if (alter < mindestalter) {
            throw new UngueltigesAlterException("Das Mindestalter für diese Attraktion beträgt " + mindestalter + " Jahre.");
        }
    }

    public static void validateGewicht(double gewicht, double maxGewicht) throws UngueltigesGewichtException {
        if (gewicht > maxGewicht) {
            throw new UngueltigesGewichtException("Das maximale Gewicht für diese Attraktion beträgt " + maxGewicht + " kg.");
        }
    }
}
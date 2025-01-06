class DolchSchurke extends Figur {
    public DolchSchurke(String characterName) {
        super(characterName, new DolchVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
class AxtSchurke extends Figur {
    public AxtSchurke(String characterName) {
        super(characterName, new AxtVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
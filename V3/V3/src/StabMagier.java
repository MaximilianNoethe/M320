class StabMagier extends Figur {
    public StabMagier(String characterName) {
        super(characterName, new StabVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
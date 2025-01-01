class AxtMagier extends Figur {
    public AxtMagier(String characterName) {
        super(characterName, new AxtVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
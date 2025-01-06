class DolchMagier extends Figur {
    public DolchMagier(String characterName) {
        super(characterName, new DolchVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
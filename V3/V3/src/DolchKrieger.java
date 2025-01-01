class DolchKrieger extends Figur {
    public DolchKrieger(String characterName) {
        super(characterName, new DolchVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
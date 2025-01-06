class AxtKrieger extends Figur {
    public AxtKrieger(String characterName) {
        super(characterName, new AxtVerhalten());
    }

    @Override
    public void kämpfen() {
        System.out.print(characterName + " ");
        waffenVerhalten.verwendeWaffe();
    }
}
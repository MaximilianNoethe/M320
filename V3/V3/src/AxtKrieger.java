class AxtKrieger extends Figur {
    public AxtKrieger(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " kämpft mit einer Axt!");
    }
}

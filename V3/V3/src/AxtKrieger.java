class AxtKrieger extends Figur {
    public AxtKrieger(String characterName) {
        super(characterName);
    }

    @Override
    public void kaempfen() {
        System.out.println(characterName + " kämpft mit einer Axt!");
    }
}

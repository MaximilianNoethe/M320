class DolchKrieger extends Figur {
    public DolchKrieger(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " kämpft mit einem Dolch!");
    }
}
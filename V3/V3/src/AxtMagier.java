class AxtMagier extends Figur {
    public AxtMagier(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " zaubert und kämpft mit einer Axt!");
    }
}
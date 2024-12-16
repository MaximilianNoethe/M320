class AxtMagier extends Figur {
    public AxtMagier(String characterName) {
        super(characterName);
    }

    @Override
    public void kaempfen() {
        System.out.println(characterName + " zaubert und kämpft mit einer Axt!");
    }
}
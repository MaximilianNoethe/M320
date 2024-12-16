class StabMagier extends Figur {
    public StabMagier(String characterName) {
        super(characterName);
    }

    @Override
    public void kaempfen() {
        System.out.println(characterName + " kämpft mit einem magischen Stab!");
    }
}
class StabMagier extends Figur {
    public StabMagier(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " kämpft mit einem magischen Stab!");
    }
}
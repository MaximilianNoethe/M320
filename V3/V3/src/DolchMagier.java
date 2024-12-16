class DolchMagier extends Figur {
    public DolchMagier(String characterName) {
        super(characterName);
    }

    @Override
    public void kaempfen() {
        System.out.println(characterName + " kämpft mit einem Dolch und zaubert!");
    }
}

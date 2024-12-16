class DolchSchurke extends Figur {
    public DolchSchurke(String characterName) {
        super(characterName);
    }

    @Override
    public void kaempfen() {
        System.out.println(characterName + " kämpft heimlich mit einem Dolch!");
    }
}
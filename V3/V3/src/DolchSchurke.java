class DolchSchurke extends Figur {
    public DolchSchurke(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " kämpft heimlich mit einem Dolch!");
    }
}
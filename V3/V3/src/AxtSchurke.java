class AxtSchurke extends Figur {
    public AxtSchurke(String characterName) {
        super(characterName);
    }

    @Override
    public void kämpfen() {
        System.out.println(characterName + " kämpft heimlich mit einer Axt!");
    }
}
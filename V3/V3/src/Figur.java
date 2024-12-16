abstract class Figur {
    protected String characterName;

    public Figur(String characterName) {
        this.characterName = characterName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public void laufen() {
        System.out.println(characterName + " läuft.");
    }

    // Abstrakte Methode kämpfen
    public abstract void kaempfen();
}
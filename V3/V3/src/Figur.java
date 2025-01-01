abstract class Figur {
    protected String characterName;
    protected WaffenVerhalten waffenVerhalten; // Aggregation: Waffen-Verhalten ist flexibel

    public Figur(String characterName, WaffenVerhalten waffenVerhalten) {
        this.characterName = characterName;
        this.waffenVerhalten = waffenVerhalten;
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

    // abstract method "kämpfen" has to be implemented in subclasses
    public abstract void kämpfen();
}
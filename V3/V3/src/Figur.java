abstract class Figur {
    protected String characterName;
    protected Waffenverhalten waffenverhalten;

    public Figur(String characterName, Waffenverhalten waffenverhalten) {
        this.characterName = characterName;
        this.waffenverhalten = waffenverhalten;
    }

    public void anzeigen(){
        System.out.println(characterName  + " - ");
        waffenverhalten.verwendetWaffe();
    }
}

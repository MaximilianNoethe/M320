public class Sekretaerin extends Person {
    private int typingSpeed;

    public Sekretaerin(String name, int birthday, String address, int typingSpeed) {
        super(name, birthday, address);
        this.typingSpeed = typingSpeed;
    }

    public int getTypingSpeed() {
        return typingSpeed;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Typing Speed: " + typingSpeed + " wpm");
    }
}

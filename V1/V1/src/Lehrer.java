public class Lehrer extends Person {
    private String subject;

    public Lehrer(String name, int birthday, String address, String subject) {
        super(name, birthday, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Subject: " + subject);
    }
}

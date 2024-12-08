public class Direktor extends Person {
    private String officeNumber;

    public Direktor(String name, int birthday, String address, String officeNumber) {
        super(name, birthday, address);
        this.officeNumber = officeNumber;
    }

    public String getOfficeNumber() {
        return officeNumber;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Office Number: " + officeNumber);
    }
}

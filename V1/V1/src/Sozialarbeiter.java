public class Sozialarbeiter extends Person {
    private int casesHandled;

    public Sozialarbeiter(String name, int birthday, String address, int casesHandled) {
        super(name, birthday, address);
        this.casesHandled = casesHandled;
    }

    public int getCasesHandled() {
        return casesHandled;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Cases Handled: " + casesHandled);
    }
}

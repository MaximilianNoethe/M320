public class Schueler extends Person {
    private String gradeLevel;

    public Schueler(String name, int birthday, String address, String gradeLevel) {
        super(name, birthday, address);
        this.gradeLevel = gradeLevel;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Grade Level: " + gradeLevel);
    }
}

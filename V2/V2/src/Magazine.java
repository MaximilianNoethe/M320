public class Magazine extends Media{
    private int issueNumber;

    public Magazine(String title, String publisher, int issueNumber) {
        super(title, publisher);
        this.issueNumber = issueNumber;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Issue Number: " + issueNumber);
    }
}

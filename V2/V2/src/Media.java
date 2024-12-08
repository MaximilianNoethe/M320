public class Media {
    private String title;
    private String publisher;

    public Media(String title, String publisher) {
        this.title = title;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void print() {
        System.out.println("Title: " + title);
        System.out.println("Publisher: " + publisher);
    }
}

public class Book extends Media {
    private String author;

    public Book(String title, String publisher, String author) {
        super(title, publisher);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Author: " + author);
    }
}

package ap.exercises.finalproject;

// Book.java
public class Book {

    private String bookId;
    private String title;
    private String author;
    private int publishYear;

    public Book(String title, String author, int publishYear, String bookId) {
        this.bookId=bookId;
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public String getBookId() {
        return bookId;
    }

    @Override
    public String toString() {
        return " BookId: " + bookId +
                " | Title: " + title +
                " | Author Name: " + author +
                " | Publish Year: " + publishYear;
    }
}
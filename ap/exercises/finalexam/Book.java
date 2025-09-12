package ap.exercises.finalexam;

public class Book extends Product {
    private final String title;
    private final String author;

    public Book(String name, int price, String title, String author) {
        super(name, price);
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + " Title: " + title + "Author: " + author;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return book.getName().equals(this.getName()) && book.getPrice() == this.getPrice()
                && book.title.equals(this.title) && book.author.equals(this.author);
    }
}

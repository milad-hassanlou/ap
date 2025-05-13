package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private int publishYear;
    private int pages;


    public Book(String title, String author, int publishYear, int pages) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Title:" + "'" + title + "'" + " " + "Author:" + "'" + author + "'" + " " + "Publish Year:" + publishYear + " " + "Pages:" + pages;
    }

    @Override
    public boolean equals(Object book) {
        Book b = (Book) book;
        return (this.title.equals(b.title) && this.author.equals(b.author));
    }
}



package ap.exercises.libraryprojectMIDTERM;

public class Book implements TabSplitAble {
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

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public String toString() {
        return "Title:" + "'" + title + "'" + " " + "Author:" + "'" + author + "'" + " " + "Publish Year:" + publishYear + " " + "Pages:" + pages;
    }

    @Override
    public String toTabSplit() {
        return title + "\t" + author + "\t" + publishYear + "\t" + pages;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Book book = (Book) obj;
        return (this.title.equalsIgnoreCase(book.title) && this.author.equalsIgnoreCase(book.author));
    }
}



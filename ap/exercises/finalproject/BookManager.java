package ap.exercises.finalproject;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books;
    private LoanBookManager loanBookManager;

    public BookManager(LoanBookManager loanBookManager) {
        this.books = new ArrayList<>();
        this.loanBookManager = loanBookManager;
    }

    public void displayAvailableBooks() {
        books.stream()
                .filter(book -> loanBookManager.isABookAvailable(book))
                .forEach(book -> System.out.println(book));
    }

    public void searchBook(String title, String author, String publishYear) {
        books.stream()
                .filter(b -> (title == null || b.getTitle().equalsIgnoreCase(title)))
                .filter(b -> (author == null || b.getAuthor().equalsIgnoreCase(author)))
                .filter(b -> (publishYear == null || b.getPublishYear() == Integer.parseInt(publishYear)))
                .forEach(b -> System.out.println(b + "| Available :" + loanBookManager.isABookAvailable(b)));
    }


    public Book searchBookById(String bookId) {
        return books.stream()
                .filter(b->b.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }
}
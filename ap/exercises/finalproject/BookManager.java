package ap.exercises.finalproject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookManager implements Serializable {
    private List<Book> books;
    private LoanBookManager loanBookManager;

    public BookManager(LoanBookManager loanBookManager) {
        this.books = new ArrayList<>();
        this.loanBookManager = loanBookManager;
    }

    public void addNewBook(Employee employee, String title, String author, int publishYear, String bookId) {
        Book newBook = new Book(employee, title, author, publishYear, bookId);
        if (isBookRepeated(newBook)) {
            System.out.println("Action Failed. The book already exists in library.");
        } else {
            books.add(newBook);
            System.out.println("The book " + newBook.getTitle() + " successfully added.");
        }
    }

    private boolean isBookRepeated(Book book) {
        int count = (int) books.stream()
                .filter(b -> b.equals(book))
                .count();
        return count != 0;
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
                .filter(b -> b.getBookId().equals(bookId))
                .findFirst()
                .orElse(null);
    }

    public void searchBYTitleForGuest(String title) {
        books.stream()
                .filter(b -> b.getTitle().equalsIgnoreCase(title))
                .forEach(b -> System.out.println(b));
    }

    public void changeBookInfo(String targetBookId, String bookId, String title, String author, String publishYear) {
        Book targetBook = searchBookById(targetBookId);
        if (targetBook == null) {
            System.out.println("Target book didn't found. Book Id-Number may not be true.");
        } else {
            if (bookId != null) {
                targetBook.setBookId(bookId);
            }

            if (title != null) {
                targetBook.setTitle(title);
            }

            if (author != null) {
                targetBook.setAuthor(author);
            }

            if (publishYear != null) {
                targetBook.setPublishYear(Integer.parseInt(publishYear));
            }

            System.out.println("Information of the book successfully changed.");
        }
    }

    public int onLoanBookCount() {
        return (int) books.stream()
                .filter(b -> !(loanBookManager.isABookAvailable(b)))
                .count();
    }

    public int bookSignedByEmployeeCount(String employeeId) {
        return (int) books.stream()
                .filter(b -> b.getBookRegisterer().getUserId().equals(employeeId))
                .count();
    }

    public int getBookCount() {
        return books.size();
    }
}
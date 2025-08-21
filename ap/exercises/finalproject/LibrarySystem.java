package ap.exercises.finalproject;

import java.time.LocalDate;

// LibrarySystem.java
public class LibrarySystem {
    private MenuHandler menuHandler;
    private StudentManager studentManager;
    private LoanBookManager loanBookManager;
    private BookManager bookManager;
    private LoanRequestManager loanRequestManager;
    private final EmployeeManager employeeManager;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.menuHandler = new MenuHandler(this);
        this.loanBookManager = new LoanBookManager();
        this.bookManager = new BookManager(this.loanBookManager);
        this.loanRequestManager = new LoanRequestManager();
        this.employeeManager = new EmployeeManager();

    }

    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public int getBookCount() {
        return this.bookManager.getBookCount();
    }

    public int getLoanHistoryCount() {
        return this.loanBookManager.getLoanHistoryCount();
    }

    public int onLoanBookCount() {
        return this.bookManager.onLoanBookCount();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public Employee authenticateEmployee(String username, String password) {
        return employeeManager.authenticateEmployee(username, password);
    }

    public void editStudentInformation(Student student, String username, String password) {
        studentManager.editStudentInformation(student, username, password);
    }

    public void borrowBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void loanBookRequest(String bookId, Student student, LocalDate startDate, LocalDate endDate) {
        Book targetBook = bookManager.searchBookById(bookId);
        if (targetBook == null) {
            System.out.println("Request failed. A book with ID : " + bookId + "do not exist.");
        } else {
            if (loanBookManager.isABookAvailable(targetBook)) {
                loanRequestManager.addLoanRequest(targetBook, student, startDate, endDate);
            } else {
                System.out.println("Your request failed. The Book is on loan.");
            }
        }
    }

    public void displayAvailableBooks() {
        bookManager.displayAvailableBooks();
    }

    public void searchBookByTitleForGuest(String title){
       bookManager.searchBYTitleForGuest(title);
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }

    public void searchBook(String title, String author, String publishYear) {
        bookManager.searchBook(title,author,publishYear);
    }
}

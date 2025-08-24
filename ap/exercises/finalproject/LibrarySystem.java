package ap.exercises.finalproject;

import java.time.LocalDate;
import java.util.List;

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

    public void registerEmployee(String name, String employeeId, String username, String password) {
        employeeManager.registerEmployee(name, employeeId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public Employee authenticateEmployee(String username, String password) {
        return employeeManager.authenticateEmployee(username, password);
    }

    public void employeePasswordChanging(Employee employee, String password){
        employeeManager.employeePasswordChanging(employee,password);
    }

    public void editStudentInformation(Student student, String username, String password) {
        studentManager.editStudentInformation(student, username, password);
    }

    public void addNewBook(String bookId, String title, String author, int publishYear) {
        bookManager.addNewBook(title, author, publishYear, bookId);
    }

    public void displayAvailableBooks() {
        bookManager.displayAvailableBooks();
    }

    public void searchBookByTitleForGuest(String title) {
        bookManager.searchBYTitleForGuest(title);
    }

    public void searchBook(String title, String author, String publishYear) {
        bookManager.searchBook(title, author, publishYear);
    }

    public void changeBookInfo(String targetBookId, String bookId, String title, String author, String publishYear) {
        bookManager.changeBookInfo(targetBookId, bookId, title, author, publishYear);
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

    public List<LoanRequest> listOfRecentRequests() {
        return loanRequestManager.listOfRecentRequests();
    }

    public void convertRequestToAcceptedLoan(Employee giverEmployee, LoanRequest request) {
        loanBookManager.addLoan(giverEmployee, request);
        loanRequestManager.deleteRequest(request);
    }

    public void displayStudentStatistics(String id) {
        Student student = studentManager.searchById(id);
        if (student == null) {
            System.out.println("There isn't any student with this Id.");
            return;
        }
        loanBookManager.displayStudentStatistics(student);
    }

    public void blockStudent(String id) {
        studentManager.addStudentToBlackList(id);
    }

    public void unblockStudent(String id) {
        studentManager.removeStudentFromBlackList(id);
    }

    public boolean isBlocked(Student student) {
        return studentManager.isBlocked(student);
    }

    public void returnLoaningBook(String bookId, Employee currentEmployee) {
        loanBookManager.returnBook(bookId,currentEmployee);
    }

    public void start() {
        menuHandler.displayMainMenu();
    }

    public static void main(String[] args) {
        LibrarySystem system = new LibrarySystem();
        system.start();
    }

    public int getEmployeeCount() {
        return employeeManager.getEmployeesCount();
    }
}

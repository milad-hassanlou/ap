package ap.exercises.finalproject;

// LibrarySystem.java
public class LibrarySystem {
    private MenuHandler menuHandler;
    private StudentManager studentManager;
    private LoanBookManager loanBookManager;
    private BookManager bookManager;

    public LibrarySystem() {
        this.studentManager = new StudentManager();
        this.menuHandler = new MenuHandler(this);
        this.loanBookManager = new LoanBookManager();
        this.bookManager = new BookManager(this.loanBookManager);
    }

    public int getStudentCount() {
        return this.studentManager.getStudentCount();
    }

    public void registerStudent(String name, String studentId, String username, String password) {
        studentManager.registerStudent(name, studentId, username, password);
    }

    public Student authenticateStudent(String username, String password) {
        return studentManager.authenticateStudent(username, password);
    }

    public void editStudentInformation(Student student,String username,String password) {
        studentManager.editStudentInformation(student,username,password);
    }

    public void borrowBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void requestOfReturningBook(Student student) {
        System.out.println("Not implemented.");
    }

    public void displayAvailableBooks() {
        bookManager.displayAvailableBooks();
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

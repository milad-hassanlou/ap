package ap.exercises.libraryprojectMIDTERM;

import java.time.LocalDate;

public class StudentsLoanBookRequest implements TabSplitAble {
    private Student student;
    private Book book;
    private LocalDate requestDate;

    public StudentsLoanBookRequest(Student student, Book book) {
        this.student = student;
        this.book = book;
        this.requestDate = LocalDate.now();
    }

    public StudentsLoanBookRequest(Student student, Book book, String requestDate) {
        this.student = student;
        this.book = book;
        this.requestDate = LocalDate.parse(requestDate);
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "{" + student.toString() + " | " + book.toString() + "}";
    }

    @Override
    public String toTabSplit() {
        return student.toTabSplit() + "\t" + book.toTabSplit() + "\t" + requestDate.toString();
    }
}

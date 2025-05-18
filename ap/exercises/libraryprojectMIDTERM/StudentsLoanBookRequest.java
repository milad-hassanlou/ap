package ap.exercises.libraryprojectMIDTERM;

import java.time.LocalDate;

public class StudentsLoanBookRequest {
    private Student student;
    private Book book;
    private LocalDate requestDate;

    public StudentsLoanBookRequest(Student student, Book book) {
        this.student = student;
        this.book = book;
        this.requestDate = LocalDate.now();
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
}

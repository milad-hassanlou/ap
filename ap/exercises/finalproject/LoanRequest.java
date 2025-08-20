package ap.exercises.finalproject;

import java.time.LocalDate;

public class LoanRequest {
    private Student student;
    private Book book;
    private LocalDate startDate;
    private LocalDate endDate;

    public LoanRequest(Student student, Book book, LocalDate startDate, LocalDate endDate) {
        this.student = student;
        this.book = book;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString(){
        return " Student -> " + student
                + " | Book -> " + book
                + " | StartDate: " + startDate
                + " | EndDate: " + endDate;
    }

}

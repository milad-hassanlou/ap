package ap.exercises.finalproject;

import java.time.LocalDate;

public class LoanBook {
    private Student student;
    private Book book;
    private Employee giverEmployee;
    private Employee getterEmployee;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate returnDate;


    public LoanBook(Student student, Book book, Employee giverEmployee, String startDate, String endDate) {
        this.student = student;
        this.book = book;
        this.giverEmployee = giverEmployee;
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public Book getBook() {
        return book;
    }

    public boolean isReturned(){
        return (returnDate!=null || getterEmployee!=null);
    }

}


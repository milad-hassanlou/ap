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


    public LoanBook(LoanRequest loanRequest, Employee giverEmployee) {
        this.student = loanRequest.getStudent();
        this.book = loanRequest.getBook();
        this.giverEmployee = giverEmployee;
        this.startDate = loanRequest.getStartDate();
        this.endDate = loanRequest.getEndDate();
    }

    public void setGetterEmployee(Employee getterEmployee) {
        this.getterEmployee = getterEmployee;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Student getStudent() {
        return student;
    }

    public Book getBook() {
        return book;
    }

    public boolean isReturned() {
        return (returnDate != null || getterEmployee != null);
    }

    public boolean isDelayedInReturning() {
        return (returnDate != null && returnDate.isAfter(endDate));
    }
}


package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;
import java.time.LocalDate;

public class LoanBook implements Serializable {
    private final int DEADLINE = 20;
    private Book book;
    private Student student;
    private Operator giverOperator;
    private Operator getterOperator;
    private LocalDate loanStartDate;
    private LocalDate loanEndDate;
    private LocalDate loanReturnDate;


    public LoanBook(Book book, Student student, Operator giverOperator) {
        this.book = book;
        this.student = student;
        this.giverOperator = giverOperator;
        this.loanStartDate = LocalDate.now();
        this.loanEndDate = loanStartDate.plusDays(DEADLINE);
    }

    public Book getBook() {
        return book;
    }

    public Operator getGiverOperator() {
        return giverOperator;
    }

    public Operator getGetterOperator() {
        return getterOperator;
    }

    public LocalDate getLoanReturnDate() {
        return loanReturnDate;
    }

    public Student getStudent() {
        return student;
    }

    public void returnBook(Operator getterOperator) {
        this.getterOperator = getterOperator;
        this.loanReturnDate = LocalDate.now();
        System.out.println("The Book Successfully Returned to Library Book Source.");
    }

    @Override
    public String toString() {
        return '{' + book.toString() + " | " + student.toString() + " | " + "Loan Start Date: " + loanStartDate + " " + "Loan End Date: " + loanEndDate + '}';
    }

    public boolean isDelayed() {
        return loanReturnDate.isAfter(loanEndDate);
    }

    public boolean isInThisYear() {
        LocalDate todayDate = LocalDate.now();
        return todayDate.getYear() == loanStartDate.getYear();
    }

    public boolean isNotReturned() {
        return loanReturnDate == null;
    }


}

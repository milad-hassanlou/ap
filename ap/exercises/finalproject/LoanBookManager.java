package ap.exercises.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanBookManager {
    private List<LoanBook> loans;

    public LoanBookManager() {
        loans = new ArrayList<>();
    }

    public void addLoan(Employee giverEmployee, LoanRequest request) {
        LoanBook newLoanBook = new LoanBook(request, giverEmployee);
        loans.add(newLoanBook);
        System.out.println("Request successfully accepted. The book is ready for borrowing.");
    }

    public boolean isABookAvailable(Book targetBook) {
        long count = loans.stream()
                .filter(l -> l.getBook() == targetBook)
                .filter(l -> !(l.isReturned()))
                .count();
        return count == 0;
    }

    public void displayStudentStatistics(Student student) {
        int allLoansCount = 0;
        int notReturnedLoansCount = 0;
        int withDelayLoansCount = 0;
        for (LoanBook loanBook : loans) {
            if (loanBook.getStudent() == student) {
                allLoansCount++;
                if (!loanBook.isReturned()) {
                    notReturnedLoansCount++;
                } else {
                    if (loanBook.isDelayedInReturning()) {
                        withDelayLoansCount++;
                    }
                }
            }
        }
        System.out.println("\n-- Student General Statistics --");
        System.out.println("All Borrowed Books: " + allLoansCount);
        System.out.println("Unreturned Books: " + notReturnedLoansCount);
        System.out.println("Overdue Books: " + withDelayLoansCount);

    }

    public int getLoanHistoryCount() {
        return loans.size();
    }

    public void returnBook(String bookId, Employee currentEmployee) {
        LoanBook loanBook = loans.stream()
                .filter(l -> l.getBook().getBookId().equals(bookId))
                .filter(l -> !(l.isReturned()))
                .findFirst()
                .orElse(null);
        if (loanBook == null) {
            System.out.println("There's not such a book on loan.");
            return;
        }
        loanBook.setGetterEmployee(currentEmployee);
        loanBook.setReturnDate(LocalDate.now());
        System.out.println("Book returned successfully.");
    }

    public Integer bookGivenByEmployeeCount(String employeeId) {
        return (int) loans.stream()
                .filter(l -> l.getGiverEmployee().getUserId().equals(employeeId))
                .count();
    }

    public Integer bookGottenByEmployeeCount(String employeeId) {
        return (int) loans.stream()
                .filter(l -> l.getGetterEmployee().getUserId().equals(employeeId))
                .count();
    }

    public int allLoansForBook(String bookId) {
        return (int) loans.stream()
                .filter(l -> l.getBook().getBookId().equals(bookId))
                .count();
    }

    public double averageBorrowingDuration(String bookId) {

        return loans.stream()
                .filter(l -> l.getBook().getBookId().equals(bookId) && l.isReturned())
                .mapToInt(l -> l.loanDuration())
                .average()
                .orElse(0);
    }
}

package ap.exercises.finalproject;

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

}

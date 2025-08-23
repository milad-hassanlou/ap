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

    public int getLoanHistoryCount() {
        return loans.size();
    }

}

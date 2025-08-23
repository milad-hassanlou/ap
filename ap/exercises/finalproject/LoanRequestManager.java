package ap.exercises.finalproject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoanRequestManager {
    private List<LoanRequest> requests;

    public LoanRequestManager() {
        this.requests = new ArrayList<>();
    }

    public void addLoanRequest(Book book, Student student, LocalDate startDate, LocalDate endDate) {
        LoanRequest request = new LoanRequest(student, book, startDate, endDate);
        requests.add(request);
        System.out.println("The request for a book signed in system.");
        System.out.println("--The Request Information: ");
        System.out.println(request);
    }

    public List<LoanRequest> listOfRecentRequests() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        return requests.stream()
                .filter(r -> r.getStartDate().isEqual(today) || r.getStartDate().isEqual(yesterday))
                .collect(Collectors.toList());
    }

    public void deleteRequest(LoanRequest request) {
        requests.remove(request);
    }
}

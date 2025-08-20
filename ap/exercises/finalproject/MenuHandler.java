package ap.exercises.finalproject;


// MenuHandler.java

import java.time.LocalDate;
import java.util.Scanner;

public class MenuHandler {
    private Scanner scanner;
    private LibrarySystem librarySystem;
    private Student currentUser;

    public MenuHandler(LibrarySystem librarySystem) {
        this.scanner = new Scanner(System.in);
        this.librarySystem = librarySystem;
        this.currentUser = null;
    }

    public void displayMainMenu() {
        while (true) {
            System.out.println("\n=== University Library Management System ===");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Guest User");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 4);

            switch (choice) {
                case 1:
                    handleStudentRegistration();
                    break;
                case 2:
                    handleStudentLogin();
                    break;
                case 3:
                    displayGuestMenu();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
            System.out.println("___________________________");
        }
    }

    private void handleStudentRegistration() {
        System.out.println("\n--- New Student Registration ---");

        System.out.print("Student name: ");
        String name = scanner.nextLine();

        System.out.print("Student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        librarySystem.registerStudent(name, studentId, username, password);
    }

    private void handleStudentLogin() {
        System.out.println("\n--- Student Login ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = librarySystem.authenticateStudent(username, password);

        if (currentUser != null) {
            System.out.println("Login successful! Welcome, " + currentUser.getName());
            displayLoggedInStudentMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private void displayLoggedInStudentMenu() {
        while (currentUser != null) {
            System.out.println("\n=== Student Dashboard ===");
            System.out.println("1. View My Information");
            System.out.println("2. Edit My Information");
            System.out.println("3. View Available Books");
            System.out.println("4. Search A Book");
            System.out.println("5. Submit A Book Loaning Request");
            System.out.println("6. Logout");
            System.out.print("Please enter your choice: ");

            int choice = getIntInput(1, 6);

            switch (choice) {
                case 1:
                    System.out.println("\n--- My Information ---");
                    System.out.println(currentUser);
                    break;
                case 2:
                    handleStudentInfoEditing();
                    break;
                case 3:
                    librarySystem.displayAvailableBooks();
                    break;
                case 4:
                    handleBookSearching();
                    break;
                case 5:
                    handleLoanRequest();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void handleStudentInfoEditing() {
        System.out.println("\n--- Student Information Editing ---");
        System.out.println("Please fill in the fields below:");

        System.out.print("New Username: ");
        String newUsername = scanner.nextLine();

        System.out.print("Password: ");
        String newPassword = scanner.nextLine();

        librarySystem.editStudentInformation(currentUser, newUsername, newPassword);
    }

    private void handleBookSearching() {
        System.out.println("\n=== Searching a Book ===");
        System.out.println("Please fill in the fields below: (you can pass a filed by Enter key if it's not necessary)");

        System.out.print("Book Title:");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) {
            title = null;
        }

        System.out.print("Author:");
        String author = scanner.nextLine().trim();
        if (author.isEmpty()) {
            author = null;
        }

        System.out.print("Publish Year:");
        String publishYear = scanner.nextLine().trim();
        if (publishYear.isEmpty()) {
            publishYear = null;
        }

        if (title == null || author == null || publishYear == null) {
            System.out.println("No information declared. Searching Failed!");
        } else {
            librarySystem.searchBook(title, author, publishYear);
        }

    }

    private void handleLoanRequest() {
        System.out.println("\n--- Submitting Loan Request ---");
        System.out.println("Please fill in the fields below:(To Find a Book and it's Id, Search Before.)");

        System.out.print("The BookId: ");
        String bookId = scanner.nextLine();

        System.out.print("Loan Start Date: (Year-Mon-Day)");
        String startPoint = scanner.nextLine();
        LocalDate startDate = null;
        try {
            startDate = LocalDate.parse(startPoint);
        } catch (Exception e) {
            System.out.println("Invalid Input For Start Date. " + "Error Message: " + e.getMessage());
        }

        System.out.print("Loan End Date: (Year-Mon-Day)");
        String endPoint = scanner.nextLine();
        LocalDate endDate = null;
        try {
            endDate = LocalDate.parse(endPoint);
        } catch (Exception e) {
            System.out.println("Invalid Input For End Date" + "Error Message: " + e.getMessage());
        }

        if (endDate.isAfter(LocalDate.now()) && startDate.isAfter(LocalDate.now()) && endDate.isAfter(startDate)) {
            librarySystem.loanBookRequest(bookId, currentUser, startDate, endDate);
        } else {
            System.out.println("Entered dates are not valid!");
        }
    }

    private void displayGuestMenu() {
        while (true) {
            System.out.println("\n--- Guest User Menu ---");
            System.out.println("1. View Registered Student Count");
            System.out.println("2. Search By Book's Title");
            System.out.println("3. Show Library Statistics ");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");


            int choice = getIntInput(1, 4);

            switch (choice) {
                case 1:
                    displayStudentCount();
                    break;
                case 2:
                    handleBookSearchingByTitle();
                    break;
                case 3:
                    displayLibraryStatistics();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void displayStudentCount() {
        int studentCount = librarySystem.getStudentCount();
        System.out.println("\nTotal registered students: " + studentCount);
    }

    private void handleBookSearchingByTitle() {
        System.out.println("\n--- Searching By Title ---");

        System.out.print("Book Title: ");
        String title = scanner.nextLine();

        librarySystem.searchBookByTitleForGuest(title);
    }

    private void displayLibraryStatistics() {
        System.out.println("\n--- Library General Statistics ---");

        System.out.print("Registered Students Count: ");
        System.out.println(librarySystem.getStudentCount());

        System.out.print("Library All Books Count: ");
        System.out.println(librarySystem.getBookCount());

        System.out.print("Book Loaning Histories Count: ");
        System.out.println(librarySystem.getLoanHistoryCount());

        System.out.print("On Loan Books Count: ");
        System.out.println(librarySystem.onLoanBookCount());

    }


    private int getIntInput(int min, int max) {
        while (true) {
            try {
                int input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) {
                    return input;
                }
                System.out.printf("Please enter a number between %d and %d: ", min, max);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
package ap.exercises.libraryprojectMIDTERM;


public class Menu {
    private Library library;
    private InputManager inputManager;

    public Menu(Library library) {
        this.library = library;
        inputManager = new InputManager();
    }

    public void showMenu() {

        System.out.println("Welcome.");
        while (true) {
            System.out.println("Choose your rule please:");
            System.out.println("1-Manager");
            System.out.println("2-Operator");
            System.out.println("3-Student");
            System.out.println("4-Exit");


            switch (inputManager.scanChoice()) {
                case 1:
                    managerMenu();
                    break;
                case 2:
                    operatorLogin();
                    break;
                case 3:
                    studentLogin();
                    break;
                case 4:
                    //Don't Need Save Nothing Changed
                    System.exit(1);
                default:
                    System.out.println("Invalid choice! Try Again...");
            }
        }
    }


    private void managerMenu() {
        System.out.println("Welcome Dear Manager.");
        while (true) {
            System.out.println("Manager Menu:");
            System.out.println("1-Add new Operator");
            System.out.println("2-Get List of Delayed Lending Books");
            System.out.println("3-Number of Given and Gotten Books for Each of Operators");
            System.out.println("4-List of Ten Books With the Most Lending in the recent year");
            System.out.println("5-Exit");

            int choice = inputManager.scanChoice();

            switch (choice) {
                case 1:
                    library.addOperator(inputManager.manageNewOperatorInput(library.getOperatorsCount()));
                    break;
                case 2:
                    System.out.println(library.listOfDelayedBooks());
                    break;
                case 3:
                    library.giveAndGetCounterForOperators();
                    break;
                case 4:
                    library.tenMostLending();
                    break;
                case 5:
                    SaveLoadCreateLibrary.saveToFile(library);
                    System.exit(2);
                    break;
                default:
                    System.out.println("Invalid choice! Try Again...");
            }
        }
    }


    private void operatorLogin() {
        System.out.println("Operator Login Actions:");
        Operator operator;
        if ((operator = library.isOperatorExists((inputManager.getOperatorID()))) != null) {
            System.out.println("Welcome Dear Operator.");
            operatorMenu(operator);
        } else {
            System.out.println("ID is Not Correct.");
            System.out.println("1-Try Again");
            System.out.println("2-Exit");

            switch (inputManager.scanChoice()) {
                case 1:
                    operatorLogin();
                    break;
                case 2:
                    SaveLoadCreateLibrary.saveToFile(library);
                    System.exit(3);
                    break;
                default:
                    System.out.println("Invalid choice! Try Again...");
            }
        }
    }

    private void operatorMenu(Operator operator) {
        while (true) {
            System.out.println("Operator Menu:");
            System.out.println("1-Edit and Complete Personal Information");
            System.out.println("2-Add new Book To Library Book Source");
            System.out.println("3-Accept Loaning Book Requests");
            System.out.println("4-Accept Returning Back the Book Requests");
            System.out.println("5-Show History of Lending and Giving Back Bocks of Myself");
            System.out.println("6-Get Loaning History of A Student (by StudentID)");
            System.out.println("7-Exit");

            switch (inputManager.scanChoice()) {
                case 1:
                    operator.setInfo(inputManager.editOperatorInfo());
                    break;
                case 2:
                    library.addBook(inputManager.manageBookInput());
                    break;
                case 3:
                    if(library.showLoanBookRequestList()) {
                        System.out.println("These Requests Are Waiting For Your Acceptance. Enter the Request Number to Accept it.");
                        StudentsLoanBookRequest acceptedRequest = library.getRequestObj(inputManager.scanChoice());
                        library.addLoan(new LoanBook(acceptedRequest.getBook(), acceptedRequest.getStudent(), operator));
                        library.removeRequest(acceptedRequest);
                    }else{
                        System.out.println("There's No Requests.");
                    }
                    break;
                case 4:
                    if(library.showReturnBookRequestList()) {
                        System.out.println("These Requests Are Waiting For Your Acceptance. Enter the Number to Accept.");
                        LoanBook targetLoanBook = library.getReturnRequestObj(inputManager.scanChoice());
                        targetLoanBook.returnBook(operator);
                        library.removeReturnBookRequest(targetLoanBook);
                    }else{
                        System.out.println("There's No Requests.");
                    }
                    break;
                case 5:
                    library.showOperatorHistory(operator);
                    break;
                case 6:
                    Student targetStudent;
                    if ((targetStudent = library.isStudentLoggedIn(inputManager.getStudentID())) != null) {
                        library.showLoaningHistory(targetStudent);
                    }else{
                        System.out.println("There's No Such a Student.");
                    }
                    break;
                case 7:
                    SaveLoadCreateLibrary.saveToFile(library);
                    System.exit(4);
                default:
                    System.out.println("Invalid choice! Try Again...");
            }
        }
    }


    private void studentLogin() {
        System.out.println("Student Login Actions:");
        System.out.println("1-Login");
        System.out.println(("2-Sign in"));
        System.out.println("3-Exit");

        int choice = inputManager.scanChoice();

        switch (choice) {
            case 1:
                Student loginStudent;
                if ((loginStudent = library.isStudentLoggedIn(inputManager.getStudentID())) != null) {
                    System.out.println("You Successfully Entered.");
                    studentMenu(loginStudent);
                } else {
                    System.out.println("The Entered Id is Not Correct or You Haven't Signed in.");
                    studentLogin();
                }
                break;
            case 2:
                Student newStudent = inputManager.manageNewStudentInput(library.getNumberOfStudents());
                library.addStudent(newStudent);
                studentMenu(newStudent);
                break;
            case 3:
                SaveLoadCreateLibrary.saveToFile(library);
                System.exit(5);
                break;
            default:
                System.out.println("Invalid choice! Try Again...");
                break;
        }
    }


    private void studentMenu(Student student) {
        while (true) {
            System.out.println("Student Menu:");
            System.out.println("1-Search");
            System.out.println("2-Book Loaning Request");
            System.out.println("3-My Loaning Books Which Haven't Returned Back");
            System.out.println("4-Return Back Lending Book Request");
            System.out.println("5-Show History of Loaning Books");
            System.out.println("6-Exit");

            switch (inputManager.scanChoice()) {
                case 1:
                    System.out.println(library.searchBook(inputManager.searchTargetBook()));
                    break;
                case 2:
                    Book targetBook = library.findBook(inputManager.searchTargetBook());
                    if (targetBook != null && !library.isBookOnLoan(targetBook)) {
                        library.addLoanRequest(new StudentsLoanBookRequest(student, targetBook));
                    }
                    break;
                case 3:
                    library.unreturnedBooks(student);
                    break;
                case 4:
                    library.registerReturnRequest(student, inputManager.searchTargetBook());
                    break;
                case 5:
                    library.showLoaningHistory(student);
                    break;
                case 6:
                    SaveLoadCreateLibrary.saveToFile(library);
                    System.exit(6);
                    break;
                default:
                    System.out.println("Invalid choice! Try Again...");
                    break;
            }
        }
    }
}


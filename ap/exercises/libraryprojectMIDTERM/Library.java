package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {
    private String libraryName;
    private LibraryManager manager;
    private ArrayList<Book> booksList = new ArrayList<>();
    private ArrayList<Student> studentsList = new ArrayList<>();
    private ArrayList<Operator> operatorsList = new ArrayList<>();
    private ArrayList<LoanBook> loansList = new ArrayList<>();


    //Add a person or Book
    public Library(String name) {
        this.libraryName = name;
    }

    public void addManager(LibraryManager manager) {
        this.manager = manager;
    }

    public void addOperator(Operator operator) {
        operatorsList.add(operator);
        System.out.println("New Operator Signed in System With EMPLOYEE ID:" + operator.getEmployeeId());
    }

    public void addStudent(Student student) {
        studentsList.add(student);
        System.out.println("New Student Signed in With STUDENT ID:" + student.getStudentId());
    }

    public void addBook(Book book) {
        booksList.add(book);
        System.out.println("The New Book Added Successfully.");

    }

    public void addLoan(LoanBook loan) {
        loansList.add(loan);
        System.out.println("The Book loaned Successfully.");
    }

    //Get Details
    public int getOperatorsCount() {
        return operatorsList.size();
    }

    public int getNumberOfStudents() {
        return studentsList.size();
    }


    //Major Actions
    public ArrayList<LoanBook> listOfDelayedBooks() {
        ArrayList<LoanBook> delayedList = new ArrayList<>();
        for (LoanBook lBook : loansList) {
            if (lBook.isDelayed()) {
                delayedList.add(lBook);
            }
        }
        return delayedList;
    }


    public void giveAndGetCounterForOperators() {
        ArrayList<Integer> givesList = new ArrayList<>();
        ArrayList<Integer> getsList = new ArrayList<>();
        int giveCounter = 0;
        int getCounter = 0;
        for (Operator operator : operatorsList) {
            for (LoanBook lBook : loansList) {
                if (operator == lBook.getGiverOperator()) {
                    giveCounter++;
                }

                if (operator == lBook.getGetterOperator()) {
                    getCounter++;
                }
            }
            givesList.add(giveCounter);
            giveCounter = 0;
            getsList.add(getCounter);
            getCounter = 0;
        }
        for (int i = 0; i < operatorsList.size(); i++) {
            System.out.printf("%d-%s Givings:%d Gettings:%d\n", i + 1, operatorsList.get(i).toString(), givesList.get(i), getsList.get(i));
        }
    }


    public void tenMostLending() {

        ArrayList<Book> copyOfBooksList = new ArrayList<>(booksList);
        ArrayList<Integer> countList = new ArrayList<>();
        int counter = 0;
        for (Book book : booksList) {
            for (LoanBook loanBook : loansList) {
                if (loanBook.getBook() == book && loanBook.isInThisYear()) {
                    counter++;
                }
            }
            countList.add(counter);
            counter = 0;
        }

        ArrayList<Book> result = new ArrayList<>();
        ArrayList<Integer> countResult = new ArrayList<>();

        int min = Math.min(10, booksList.size());
        int maxFrequency = 0;
        for (int i = 0; i < min; i++) {

            for (int c : countList) {
                if (c > maxFrequency) {
                    maxFrequency = c;
                }
            }
            int maxIndex = countList.indexOf(maxFrequency);
            result.add(copyOfBooksList.get(maxIndex));
            countResult.add(maxFrequency);
            copyOfBooksList.remove(maxIndex);
            countList.remove(maxIndex);
            maxFrequency = 0;
        }

        if (result.size() == 0) {
            System.out.println("There's No Books In List.");
        } else {
            for (int i = 0; i < result.size(); i++) {
                System.out.printf("%d-%s  -----> Repetition:%d\n", i + 1, result.get(i).toString(), countResult.get(i));
            }
        }
    }

    public Operator isOperatorExists(int id) {
        for (Operator operator : operatorsList) {
            if (operator.isIdSimilar(id)) {
                return operator;
            }
        }
        return null;
    }

    public Student isStudentLoggedIn(int id) {
        for (Student student : studentsList) {
            if (student.isIdSimilar(id)) {
                return student;
            }
        }
        return null;
    }

    public boolean isOnLoan(Book book) {
        for (LoanBook lBook : loansList) {
            if (lBook.getBook() == book && lBook.getLoanReturnDate() == null) {
                return true;
            }
        }
        return false;
    }

    public String searchBook(Book targetBook) {
        String loanStatus = "";
        for (Book book : booksList) {
            if (book.equals(targetBook)) {

                if (this.isOnLoan(book)) {
                    loanStatus = "The Book is On loan.";
                } else {
                    loanStatus = "The Book Exists";
                }
                return book.toString() + "\t" + "Status:" + loanStatus;
            }
        }
        return "Such a Book Not Found!";
    }
}
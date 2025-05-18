package ap.exercises.libraryprojectMIDTERM;

import java.util.Scanner;

public class InputManager {

    private Scanner scan;

    public InputManager() {
        scan = new Scanner(System.in);
    }

    public void closeScanner() {
        scan.close();
    }

    public int scanChoice() {
        System.out.print("Please Choose one Option:");
        if (scan.hasNextInt()) {
            int choice = scan.nextInt();
            scan.nextLine();
            return choice;
        } else {
            return -1;
        }
    }

    public Book manageBookInput() {
        System.out.println("Please Enter Information of New Book:");

        System.out.print("Title:");
        String title = scan.nextLine();

        System.out.print("Author:");
        String author = scan.nextLine();

        System.out.print("Publish Year:");
        int publishYear = scan.nextInt();
        scan.nextLine();

        System.out.print("Pages:");
        int pages = scan.nextInt();
        scan.nextLine();

        return new Book(title, author, publishYear, pages);
    }


    public int getStudentID() {
        System.out.print("Please Input Your Student ID Code:");
        int id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public int getOperatorID() {
        System.out.print("Please Input Your Employee ID Code:");
        int id = scan.nextInt();
        scan.nextLine();
        return id;
    }


    public Student manageNewStudentInput(int previousStudentInList) {
        System.out.println("Please Input Needed Information:");
        System.out.print("First Name:");
        String fName = scan.nextLine();
        System.out.print("Last Name:");
        String lName = scan.nextLine();
        System.out.print("Discipline:");
        String discipline = scan.nextLine();
        return new Student(previousStudentInList, fName, lName, discipline);
    }

    public Operator manageNewOperatorInput(int previousOperators) {
        System.out.println("Please Input new Operator's Necessary Information:");
        System.out.print("First Name:");
        String fName = scan.nextLine();
        System.out.print("Last Name:");
        String lName = scan.nextLine();
        return new Operator(previousOperators, fName, lName);
    }

    public String[] editOperatorInfo() {
        String[] infos = new String[3];
        System.out.println("Edit Information Bellow:");
        System.out.print("First Name:");
        infos[0] = scan.nextLine();
        System.out.print("Last Name:");
        infos[1] = scan.nextLine();
        System.out.print("Educational Level:");
        infos[2] = scan.nextLine();
        return infos;
    }

    public Book searchTargetBook() {
        System.out.println("Please Enter The Target Book Information: ");
        System.out.print("Book Title:");
        String title = scan.nextLine();
        System.out.print("Author Name:");
        String author = scan.nextLine();
        return new Book(title, author, 0, 0);
    }
}
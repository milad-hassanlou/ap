package ap.exercises.ex3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class Book {
    public String bookTitle;
    public String authorName;
    public int bookPages;
    public int publishYear;
}

class Student {
    public String firstName;
    public String lastName;
    public int studentNumber;
    public String studyField;
}

public class Main_EX3_LM_1_2_A {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner get = new Scanner(System.in);

        //Writing to Files

        Book[] books = new Book[4];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            System.out.println("Book" + (i + 1) + "->");

            System.out.print("Book Title:");
            books[i].bookTitle = get.nextLine();

            System.out.print("Author Name:");
            books[i].authorName = get.nextLine();

            System.out.print("Book Pages:");
            books[i].bookPages = get.nextInt();

            System.out.print("Book Publish Year:");
            books[i].publishYear = get.nextInt();
            get.nextLine();
        }

        PrintWriter inputBook = new PrintWriter("E:/Codings Related Files/Temp/TempFilesInCodes/booksSaveFile(Main_EX3_LM_1_2).txt");
        for (int i = 0; i < books.length; i++) {
            inputBook.println(books[i].bookTitle);
            inputBook.println(books[i].authorName);
            inputBook.println(books[i].bookPages);
            inputBook.println(books[i].publishYear);
        }
        inputBook.close();

        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            System.out.println("Student" + (i + 1) + "->");

            System.out.print("First Name:");
            students[i].firstName = get.nextLine();

            System.out.print("Last Name:");
            students[i].lastName = get.nextLine();

            System.out.print("Student Number:");
            students[i].studentNumber = get.nextInt();
            get.nextLine();

            System.out.print("Study Field:");
            students[i].studyField = get.nextLine();
        }

        PrintWriter inputStudent = new PrintWriter("E:/Codings Related Files/Temp/TempFilesInCodes/studentsSaveFile(Main_EX3_LM_1_2).txt");
        for (int i = 0; i < students.length; i++) {
            inputStudent.println(students[i].firstName);
            inputStudent.println(students[i].lastName);
            inputStudent.println(students[i].studentNumber);
            inputStudent.println(students[i].studyField);
        }
        inputStudent.close();
    }
}

package ap.exercises.ex3;

import java.io.File;
import java.io.FileNotFoundException;
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

public class Main_EX3_LM_1_2_B {
    public static void main(String[] args) throws FileNotFoundException {

        //Reading from Files

        File fileBook = new File("E:/Codings Related Files/Temp/TempFilesInCodes/booksSaveFile(Main_EX3_LM_1_2).txt");
        Scanner getBook = new Scanner(fileBook);
        Book[] books = new Book[4];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book();
            books[i].bookTitle = getBook.nextLine();
            books[i].authorName = getBook.nextLine();
            books[i].bookPages = getBook.nextInt();
            books[i].publishYear = getBook.nextInt();
            getBook.nextLine();
        }
        getBook.close();

        for (int i = 0; i < books.length; i++) {
            System.out.println("Book" + (i + 1) + ":");
            System.out.println("Book Title:" + books[i].bookTitle);
            System.out.println("Author Name:" + books[i].authorName);
            System.out.println("Book Pages:" + books[i].bookPages);
            System.out.println("Publish Year:" + books[i].publishYear);
            System.out.println();
        }

        File fileStudent = new File("E:/Codings Related Files/Temp/TempFilesInCodes/studentsSaveFile(Main_EX3_LM_1_2).txt");
        Scanner getStudent = new Scanner(fileStudent);
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].firstName = getStudent.nextLine();
            students[i].lastName = getStudent.nextLine();
            students[i].studentNumber = getStudent.nextInt();
            getStudent.nextLine();
            students[i].studyField = getStudent.nextLine();
        }
        getStudent.close();

        for (int i = 0; i < students.length; i++) {
            System.out.println("Student" + (i + 1) + ":");
            System.out.println("First Name:" + students[i].firstName);
            System.out.println("Last Name:" + students[i].lastName);
            System.out.println("Student Number:" + students[i].studentNumber);
            System.out.println("Study Field:" + students[i].studyField);
            System.out.println();
        }
    }
}

package ap.exercises.ex3;

import java.io.File;
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

public class Main_EX3_LM_1_2_C {

    static void writeBook(Book[] bookArr) throws FileNotFoundException {
        PrintWriter inputBook = new PrintWriter("E:/Codings Related Files/Temp/TempFilesInCodes/booksSaveFile(Main_EX3_LM_1_2).txt");
        for (int i = 0; i < bookArr.length; i++) {
            inputBook.println(bookArr[i].bookTitle);
            inputBook.println(bookArr[i].authorName);
            inputBook.println(bookArr[i].bookPages);
            inputBook.println(bookArr[i].publishYear);
        }
        inputBook.close();
    }

    static void writeStudent(Student[] studentArr) throws FileNotFoundException {
        PrintWriter inputStudent = new PrintWriter("E:/Codings Related Files/Temp/TempFilesInCodes/studentsSaveFile(Main_EX3_LM_1_2).txt");
        for (int i = 0; i < studentArr.length; i++) {
            inputStudent.println(studentArr[i].firstName);
            inputStudent.println(studentArr[i].lastName);
            inputStudent.println(studentArr[i].studentNumber);
            inputStudent.println(studentArr[i].studyField);
        }
        inputStudent.close();
    }

    static void readBook(Book[] bookArr) throws FileNotFoundException {
        File fileBook = new File("E:/Codings Related Files/Temp/TempFilesInCodes/booksSaveFile(Main_EX3_LM_1_2).txt");
        Scanner getBook = new Scanner(fileBook);
        for (int i = 0; i < bookArr.length; i++) {
            bookArr[i].bookTitle = getBook.nextLine();
            bookArr[i].authorName = getBook.nextLine();
            bookArr[i].bookPages = getBook.nextInt();
            bookArr[i].publishYear = getBook.nextInt();
            getBook.nextLine();
        }
        getBook.close();
    }

    static void readStudent(Student[] studentArr) throws FileNotFoundException {
        File fileStudent = new File("E:/Codings Related Files/Temp/TempFilesInCodes/studentsSaveFile(Main_EX3_LM_1_2).txt");
        Scanner getStudent = new Scanner(fileStudent);
        for (int i = 0; i < studentArr.length; i++) {
            studentArr[i].firstName = getStudent.nextLine();
            studentArr[i].lastName = getStudent.nextLine();
            studentArr[i].studentNumber = getStudent.nextInt();
            getStudent.nextLine();
            studentArr[i].studyField = getStudent.nextLine();
        }
        getStudent.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner get = new Scanner(System.in);

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
        writeBook(books);


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
        writeStudent(students);

        Book[] newBooks = new Book[4];
        for (int i = 0; i < newBooks.length; i++) {
            newBooks[i] = new Book();
        }
        readBook(newBooks);
        for (int i = 0; i < newBooks.length; i++) {
            System.out.println("Book" + (i + 1) + ":");
            System.out.println("Book Title:" + newBooks[i].bookTitle);
            System.out.println("Author Name:" + newBooks[i].authorName);
            System.out.println("Book Pages:" + newBooks[i].bookPages);
            System.out.println("Publish Year:" + newBooks[i].publishYear);
            System.out.println();
        }

        Student[] newStudents = new Student[3];
        for (int i = 0; i < newStudents.length; i++) {
            newStudents[i] = new Student();
        }
        readStudent(newStudents);
        for (int i = 0; i < newStudents.length; i++) {
            System.out.println("Student" + (i + 1) + ":");
            System.out.println("First Name:" + newStudents[i].firstName);
            System.out.println("Last Name:" + newStudents[i].lastName);
            System.out.println("Student Number:" + newStudents[i].studentNumber);
            System.out.println("Study Field:" + newStudents[i].studyField);
            System.out.println();
        }
    }
}

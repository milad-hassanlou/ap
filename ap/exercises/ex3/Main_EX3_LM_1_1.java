package ap.exercises.ex3;

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

public class Main_EX3_LM_1_1 {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.bookTitle = "Big Java";
        b1.authorName = "Cay Horstmann";
        b1.bookPages = 1377;
        b1.publishYear = 1975;

        Book b2 = new Book();
        b2.bookTitle = "Discrete Mathematics";
        b2.authorName = "Rosen Kenneth";
        b2.bookPages = 917;
        b2.publishYear = 1980;

        Student s1 = new Student();
        s1.firstName = "Milad";
        s1.lastName = "Hassanlou";
        s1.studentNumber = 403463000;
        s1.studyField = "Computer Engineering";

        Student s2 = new Student();
        s2.firstName = "Mohammad Mahdi";
        s2.lastName = "Davirani";
        s2.studentNumber = 403463010;
        s2.studyField = "Computer Programming";
    }
}

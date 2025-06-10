package ap.exercises.libraryprojectMIDTERM;

import java.time.LocalDate;

public class Student extends Person implements TabSplitAble {
    private final int STUDENT_Id;
    private String discipline;
    private LocalDate signInDate;

    public Student(int previousStudents, String firstName, String lastName, String discipline) {
        super(firstName, lastName);
        this.STUDENT_Id = 403463001 + previousStudents;
        this.discipline = discipline;
        this.signInDate = LocalDate.now();
    }

    public Student(int studentId, String firstName, String lastName, String discipline,String signInDate) {
        super(firstName, lastName);
        this.STUDENT_Id = studentId;
        this.discipline = discipline;
        this.signInDate = LocalDate.parse(signInDate);
    }

    public int getSTUDENT_Id() {
        return STUDENT_Id;
    }

    public String getDiscipline() {
        return discipline;
    }

    public LocalDate getSignInDate() {
        return signInDate;
    }

    public int getStudentId() {
        return STUDENT_Id;
    }

    public boolean isIdSimilar(int id) {
        return this.STUDENT_Id == id;
    }

    public boolean equals(Object b) {
        if (this == b) {
            return true;
        }
        if (b == null || b.getClass() != this.getClass()) {
            return false;
        }
        Student operator = (Student) b;
        return (this.STUDENT_Id == operator.STUDENT_Id);
    }

    @Override
    public String toTabSplit() {
        return STUDENT_Id + "\t" + super.toTabSplit() + "\t" + discipline + "\t" + signInDate.toString();
    }
}

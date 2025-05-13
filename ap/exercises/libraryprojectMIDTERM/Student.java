package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;
import java.time.LocalDate;

public class Student extends Person implements Serializable {
    private final int STUDENT_Id;
    private String discipline;
    private LocalDate signInDate;

    public Student(int previousStudents, String firstName, String lastName, String discipline) {
        super(firstName, lastName);
        this.STUDENT_Id = 403463001 + previousStudents;
        this.discipline = discipline;
        this.signInDate = LocalDate.now();
    }

    public int getStudentId() {
        return STUDENT_Id;
    }

    public boolean isIdSimilar(int id) {
        return this.STUDENT_Id == id;
    }
}

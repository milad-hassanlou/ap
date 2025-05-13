package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;

public class LibraryManager extends Person implements Serializable {
    private String educationalLevel;

    public LibraryManager(String firstName, String lastName, String educationalLevel) {
        super(firstName, lastName);
        this.educationalLevel = educationalLevel;
    }
}

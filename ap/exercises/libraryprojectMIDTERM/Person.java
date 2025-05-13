package ap.exercises.libraryprojectMIDTERM;

import java.io.Serializable;

public class Person implements Serializable {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "FirstName:" + "'" + this.lastName + "'" + "LastName:" + "'" + this.firstName + "'";
    }
}

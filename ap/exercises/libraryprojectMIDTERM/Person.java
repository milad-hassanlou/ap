package ap.exercises.libraryprojectMIDTERM;


public class Person implements TabSplitAble {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toTabSplit() {
        return firstName + "\t" + lastName;
    }

    @Override
    public String toString() {
        return "FirstName:" + "'" + this.lastName + "'" + "LastName:" + "'" + this.firstName + "'";
    }
}

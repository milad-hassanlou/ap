package ap.exercises.libraryprojectMIDTERM;



public class LibraryManager extends Person implements TabSplitAble {
    private String educationalLevel;

    public LibraryManager(String firstName, String lastName, String educationalLevel) {
        super(firstName, lastName);
        this.educationalLevel = educationalLevel;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    @Override
    public String toTabSplit() {
        return super.toTabSplit() + "\t" + educationalLevel;
    }

}

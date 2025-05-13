package ap.exercises.libraryprojectMIDTERM;

public class Main {
    public static void main(String[] args) {

        Library library = SaveLoadCreateLibrary.loadFromFileOrCreate();
        Menu menu = new Menu(library);
        menu.showMenu();

    }
}

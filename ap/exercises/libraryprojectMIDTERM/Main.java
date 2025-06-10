package ap.exercises.libraryprojectMIDTERM;

import ap.exercises.libraryprojectMIDTERM.persistence.HandleStorageManager;

public class Main {
    public static void main(String[] args) {
        InputManager inputManager = new InputManager();
        final String CONFIG_FILE_PATH = "ap/exercises/libraryprojectMIDTERM/persistence/config.txt";
        HandleStorageManager storageManager = new HandleStorageManager(CONFIG_FILE_PATH,inputManager);
        storageManager.start();

        Library library = storageManager.getLibrary();
        Menu menu = new Menu(library,inputManager,storageManager.getSuitableStorageManager());
        menu.showMenu();
    }
}



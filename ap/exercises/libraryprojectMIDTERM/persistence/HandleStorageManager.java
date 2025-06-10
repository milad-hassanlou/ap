package ap.exercises.libraryprojectMIDTERM.persistence;

import ap.exercises.libraryprojectMIDTERM.InputManager;
import ap.exercises.libraryprojectMIDTERM.Library;
import ap.exercises.libraryprojectMIDTERM.LibraryManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class HandleStorageManager {
    private String configFilePath;
    private Library library;
    private ParentStorageManager SuitableStorageManager;
    private InputManager inputManager;


    public HandleStorageManager(String configFilePath,InputManager inputManager) {
        this.configFilePath = configFilePath;
        this.inputManager = inputManager;
    }

    public Library getLibrary() {
        return library;
    }

    public ParentStorageManager getSuitableStorageManager() {
        return SuitableStorageManager;
    }

    private boolean isSaveExist() {
        File saveFile = new File(configFilePath);
        return saveFile.exists();
    }

    private String getDateBaseType() {
        File path = new File(configFilePath);
        try (Scanner scan = new Scanner((path))){
            if (scan.hasNext()) {
                String configContent = scan.nextLine();
                String storageType = configContent.substring(configContent.indexOf("=") + 1);
                return storageType;
            } else {
                System.out.println("Unable to Get Storage Type. -> " + configFilePath + "Is Empty.");
                return "";
            }
        } catch (
                Exception e) {
            System.out.println("Unable to Open: " + configFilePath + "->" + e.getMessage());
            return "";
        }
    }

    public ParentStorageManager getAppropriateStorageManager(String storageType) {
        switch (storageType) {
            case "tabsplit":
                return new TabsplitStorageManager(configFilePath);
            case "json":
                return new JsonStorageManager(configFilePath);
            case "sqlite":
                return new SqliteStorageManager(configFilePath);
        }
        return null;
    }

    private void createConfigFile(String storageType){
        try (PrintWriter write = new PrintWriter(this.configFilePath)){
            write.println("storage="+storageType);
        }catch (IOException e){
            System.out.println("Unable To Create Config File.");
        }
    }

    private Library createLibrary(){
        System.out.println("{New Library Created.}");
        Library library = new Library("ZNU Central Library");
        library.addManager(new LibraryManager("Saeed", "Rahmani", "PhD"));
        return library;
    }


    public void start() {
        if (isSaveExist()) {
            String storageType = getDateBaseType();
            this.SuitableStorageManager = getAppropriateStorageManager(storageType);
            this.library = SuitableStorageManager.loadLibrary();
        }
        if (!isSaveExist()) {
            String storageType = inputManager.chooseStorageType();
            createConfigFile(storageType);
            this.SuitableStorageManager = getAppropriateStorageManager(storageType);
            this.library = createLibrary();
        }
    }
}

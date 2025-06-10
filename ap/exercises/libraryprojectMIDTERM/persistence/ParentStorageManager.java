package ap.exercises.libraryprojectMIDTERM.persistence;

import ap.exercises.libraryprojectMIDTERM.Library;

public abstract class ParentStorageManager {
    protected String configDirectoryPath;

    public ParentStorageManager(String configFilePath) {
        this.configDirectoryPath = configFilePath.substring(0,configFilePath.lastIndexOf("/"));
    }

    public abstract Library loadLibrary();

    public abstract void saveLibrary(Library library);

}

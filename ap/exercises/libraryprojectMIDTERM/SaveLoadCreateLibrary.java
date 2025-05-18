package ap.exercises.libraryprojectMIDTERM;

import java.io.*;

public class SaveLoadCreateLibrary implements Serializable {
    public static void saveToFile(Library lib) {
        try {
            FileOutputStream outFile = new FileOutputStream("DataBaseOfLibrary.bin");
            ObjectOutputStream out = new ObjectOutputStream(outFile);
            out.writeObject(lib);
            out.close();
            outFile.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static Library loadFromFileOrCreate() {
        try {
            System.out.println("{Loading Information's of Library...}");
            FileInputStream fileIn = new FileInputStream("DataBaseOfLibrary.bin");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            return (Library) in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("{Nothing Found in File. New Library Created.}");
            Library library = new Library("ZNU Central Library");
            library.addManager(new LibraryManager("Saeed", "Rahmani", "PhD"));
            return library;
        } catch (Exception a) {
            System.out.println("Error: " + a.getMessage());
            return null;
        }
    }
}

package ap.exercises.libraryprojectMIDTERM.persistence;

import ap.exercises.libraryprojectMIDTERM.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ap.exercises.libraryprojectMIDTERM.libs.LocalDateAdapter;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class JsonStorageManager extends ParentStorageManager {
    private Gson gson;

    public JsonStorageManager(String configFilePath) {
        super(configFilePath);
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }


    private void save(Object obj, String saveFileName) {
        String saveFilePath = super.configDirectoryPath + "/" + saveFileName + ".txt";
        try {
            FileWriter fileWriter = new FileWriter(saveFilePath, true);
            PrintWriter print = new PrintWriter(fileWriter);
            print.println(gson.toJson(obj));
            print.close();
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("Error Saving: " + e.getMessage());
        }
    }


    @Override
    public void saveLibrary(Library library) {
        //Delete Previous Save Files:
        try {
            File libraryDetails = new File(super.configDirectoryPath + "/" + "libraryDetails" + ".txt");
            File books = new File(super.configDirectoryPath + "/" + "books" + ".txt");
            File students = new File(super.configDirectoryPath + "/" + "students" + ".txt");
            File operators = new File(super.configDirectoryPath + "/" + "operators" + ".txt");
            File loanBooks = new File(super.configDirectoryPath + "/" + "loanBooks" + ".txt");
            File loanBookRequests = new File(super.configDirectoryPath + "/" + "loanBookRequests" + ".txt");
            File returnRequests = new File(super.configDirectoryPath + "/" + "returnRequests" + ".txt");
            libraryDetails.delete();
            books.delete();
            students.delete();
            operators.delete();
            loanBooks.delete();
            loanBookRequests.delete();
            returnRequests.delete();
        } catch (Exception e) {
            System.out.println("Error Deleting Files: " + e.getMessage());
        }


        //Write Library Name:
        try (PrintWriter writer = new PrintWriter(super.configDirectoryPath + "/" + "libraryDetails" + ".txt")) {
            writer.println(library.getLibraryName());
        } catch (Exception e) {
            System.out.println("Error Saving: " + e.getMessage());
        }

        //Write Library Manager:
        this.save(library.getManager(), "libraryDetails");

        //Write Library BookList:
        ArrayList<Book> list1 = library.getBooksList();
        for (Book book : list1) {
            save(book, "books");
        }

        //Write Library StudentList:
        ArrayList<Student> list2 = library.getStudentsList();
        for (Student student : list2) {
            save(student, "students");
        }

        //Write Library OperatorList:
        ArrayList<Operator> list3 = library.getOperatorsList();
        for (Operator operator : list3) {
            save(operator, "operators");
        }

        //Write Library LoansList:
        ArrayList<LoanBook> list4 = library.getLoansList();
        for (LoanBook loanBook : list4) {
            save(loanBook, "loanBooks");
        }

        //Write Library LoanBooksRequestsList:
        ArrayList<StudentsLoanBookRequest> list5 = library.getLoanBookRequestsList();
        for (StudentsLoanBookRequest loanBookRequest : list5) {
            save(loanBookRequest, "loanBookRequests");
        }

        //Write Library ReturnRequestsList:
        ArrayList<LoanBook> list6 = library.getReturnRequestsList();
        for (LoanBook lBook : list6) {
            save(lBook, "returnRequests");
        }
    }

    @Override
    public Library loadLibrary() {

        String libraryName;
        LibraryManager manager;
        ArrayList<Book> booksList = new ArrayList<>();
        ArrayList<Student> studentsList = new ArrayList<>();
        ArrayList<Operator> operatorsList = new ArrayList<>();
        ArrayList<LoanBook> loansList = new ArrayList<>();
        ArrayList<StudentsLoanBookRequest> loanBookRequestsList = new ArrayList<>();
        ArrayList<LoanBook> returnRequestsList = new ArrayList<>();

        //Read Library Name & Library Manager:
        File path = new File(super.configDirectoryPath + "/" + "libraryDetails" + ".txt");
        try (Scanner scan = new Scanner(path)) {
            libraryName = scan.nextLine();
            String line = scan.nextLine();
            manager = gson.fromJson(line, LibraryManager.class);
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
            libraryName = "Not Found.";
            manager = new LibraryManager("Not Found.", "Not Found.", "Not Found.");
        }

        //Read Library Books:
        String path1 = super.configDirectoryPath + "/" + "books" + ".txt";
        try {
            booksList = Files.lines(Paths.get(path1))
                    .map(s -> gson.fromJson(s, Book.class))
                    .collect(Collectors.toCollection(ArrayList::new));

        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        //Read Library Students:
        String path2 = super.configDirectoryPath + "/" + "students" + ".txt";
        try {
            studentsList = Files.lines(Paths.get(path2))
                    .map(s -> gson.fromJson(s, Student.class))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        //Read Library Operators:
        String path3 = super.configDirectoryPath + "/" + "operators" + ".txt";
        try {
            operatorsList = Files.lines(Paths.get(path3))
                    .map(s -> gson.fromJson(s, Operator.class))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        //Read Library LoansList:
        String path4 = super.configDirectoryPath + "/" + "loanBooks" + ".txt";
        try {
            loansList = Files.lines(Paths.get(path4))
                    .map(s -> gson.fromJson(s, LoanBook.class))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }


        //Read Library loanBookRequestsList
        String path5 = super.configDirectoryPath + "/" + "loanBookRequests" + ".txt";
        try {
            loanBookRequestsList = Files.lines(Paths.get(path5))

                    .map(s -> gson.fromJson(s, StudentsLoanBookRequest.class))
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        //Read Library returnRequestList:
        String path6 = super.configDirectoryPath + "/" + "returnRequests" + ".txt";
        try {
            returnRequestsList = Files.lines(Paths.get(path6))
                    .map(s ->gson.fromJson(s,LoanBook.class))
                            .collect(Collectors.toCollection(ArrayList::new));
        } catch (Exception e) {
            System.out.println("Error loading: " + e.getMessage());
        }

        return new Library(libraryName, manager, booksList, studentsList, operatorsList, loansList, loanBookRequestsList, returnRequestsList);
    }

}



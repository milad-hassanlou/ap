package ap.exercises.libraryprojectMIDTERM.persistence;

import ap.exercises.libraryprojectMIDTERM.*;
import java.sql.*;
import java.util.ArrayList;

public class SqliteStorageManager extends ParentStorageManager {
    private String dataBasePath;

    public SqliteStorageManager(String configFilePath) {
        super(configFilePath);
        this.dataBasePath = "jdbc:sqlite:" + super.configDirectoryPath + "/library.txt";
        createTablesIfNotExists();
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(dataBasePath);
    }

    private void createTablesIfNotExists() {
        try (
                Connection conn = connect();
                Statement statement = conn.createStatement()
        ){
            // LibraryManager table
            statement.execute("CREATE TABLE IF NOT EXISTS LibraryManager (firstName TEXT, lastName TEXT, educationalLevel TEXT)");

            // Books table
            statement.execute("CREATE TABLE IF NOT EXISTS Books (title TEXT, author TEXT, publishYear INT, pages INT)");

            // Students table
            statement.execute("CREATE TABLE IF NOT EXISTS Students (id INT, firstName TEXT, lastName TEXT, dicipline TEXT,signInDate TEXT)");

            // Operators table
            statement.execute("CREATE TABLE IF NOT EXISTS Operators (id INT, firstName TEXT, lastName TEXT, cosVersionAlways2 INT)");

            // Loans table
            statement.execute("CREATE TABLE IF NOT EXISTS Loans (title TEXT, author TEXT, publishYear INT, pages INT, " +
                    "studentid INT, firstName TEXT, lastName TEXT, dicipline TEXT,signInDate TEXT, " +
                    "giverId INT, giverFirstName TEXT, giverLastName TEXT, giverCosVersionAlways2 INT, " +
                    "getterId INT, getterFirstName TEXT, getterLastName TEXT, getterCosVersionAlways2 INT, " +
                    "startDate TEXT, endDate TEXT)");

            // LoanRequests table
            statement.execute("CREATE TABLE IF NOT EXISTS LoanRequests (id INT, firstName TEXT, lastName TEXT, dicipline TEXT,signInDate TEXT, " +
                    "title TEXT, author TEXT, publishYear INT, pages INT, requestDate TEXT)");

            // ReturnRequests table
            statement.execute("CREATE TABLE IF NOT EXISTS ReturnRequests AS SELECT * FROM Loans WHERE 0");
        } catch (SQLException e) {
            System.out.println("Error creating tables: " + e.getMessage());
        }
    }

    private void clearAllTables() {
        try (
                Connection conn = connect();
                Statement statement = conn.createStatement()
        ) {
            statement.execute("DELETE FROM LibraryManager");
            statement.execute("DELETE FROM Books");
            statement.execute("DELETE FROM Students");
            statement.execute("DELETE FROM Operators");
            statement.execute("DELETE FROM Loans");
            statement.execute("DELETE FROM LoanRequests");
            statement.execute("DELETE FROM ReturnRequests");
        } catch (SQLException e) {
            System.out.println("Error clearing tables: " + e.getMessage());
        }
    }

    @Override
    public void saveLibrary(Library library) {
        clearAllTables();
        try (Connection conn = connect()) {
            // Save Manager
            PreparedStatement ps = conn.prepareStatement("INSERT INTO LibraryManager VALUES (?, ?, ?)");
            LibraryManager m = library.getManager();
            ps.setString(1, m.getFirstName());
            ps.setString(2, m.getLastName());
            ps.setString(3, m.getEducationalLevel());
            ps.executeUpdate();

            // Save Books
            for (Book b : library.getBooksList()) {
                ps = conn.prepareStatement("INSERT INTO Books VALUES (?, ?, ?, ?)");
                ps.setString(1, b.getTitle());
                ps.setString(2, b.getAuthor());
                ps.setInt(3, b.getPublishYear());
                ps.setInt(4, b.getPages());
                ps.executeUpdate();
            }

            // Save Students
            for (Student s : library.getStudentsList()) {
                ps = conn.prepareStatement("INSERT INTO Students VALUES (?, ?, ?, ?,?)");
                ps.setInt(1, s.getSTUDENT_Id());
                ps.setString(2, s.getFirstName());
                ps.setString(3, s.getLastName());
                ps.setString(4, s.getDiscipline());
                ps.setString(5, s.getSignInDate().toString());
                ps.executeUpdate();
            }

            // Save Operators
            for (Operator o : library.getOperatorsList()) {
                ps = conn.prepareStatement("INSERT INTO Operators VALUES (?, ?, ?, ?)");
                ps.setInt(1, o.getEMPLOYEE_ID());
                ps.setString(2, o.getFirstName());
                ps.setString(3, o.getLastName());
                ps.setInt(4, 2);
                ps.executeUpdate();
            }

            // Save Loans
            for (LoanBook l : library.getLoansList()) {
                ps = conn.prepareStatement("INSERT INTO Loans VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
                Book b = l.getBook();
                Student s = l.getStudent();
                Operator g1 = l.getGiverOperator();
                Operator g2 = l.getGetterOperator();
                ps.setString(1, b.getTitle());
                ps.setString(2, b.getAuthor());
                ps.setInt(3, b.getPublishYear());
                ps.setInt(4, b.getPages());
                ps.setInt(5, s.getSTUDENT_Id());
                ps.setString(6, s.getFirstName());
                ps.setString(7, s.getLastName());
                ps.setString(8, s.getDiscipline());
                ps.setString(9, s.getSignInDate().toString());
                ps.setInt(10, g1.getEMPLOYEE_ID());
                ps.setString(11, g1.getFirstName());
                ps.setString(12, g1.getLastName());
                ps.setInt(13, 2);
                ps.setInt(14, g2.getEMPLOYEE_ID());
                ps.setString(15, g2.getFirstName());
                ps.setString(16, g2.getLastName());
                ps.setInt(17, 2);
                ps.setString(18, l.getLoanStartDate().toString());
                ps.setString(19, l.getLoanEndDate().toString());
                ps.executeUpdate();
            }

            // Save LoanRequests
            for (StudentsLoanBookRequest req : library.getLoanBookRequestsList()) {
                ps = conn.prepareStatement("INSERT INTO LoanRequests VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                Student s = req.getStudent();
                Book b = req.getBook();
                ps.setInt(1, s.getSTUDENT_Id());
                ps.setString(2, s.getFirstName());
                ps.setString(3, s.getLastName());
                ps.setString(4, s.getDiscipline());
                ps.setString(5, s.getSignInDate().toString());
                ps.setString(6, b.getTitle());
                ps.setString(7, b.getAuthor());
                ps.setInt(8, b.getPublishYear());
                ps.setInt(9, b.getPages());
                ps.setString(10, req.getRequestDate().toString());
                ps.executeUpdate();
            }

            // Save ReturnRequests
            for (LoanBook l : library.getReturnRequestsList()) {
                ps = conn.prepareStatement("INSERT INTO ReturnRequests VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
                Book b = l.getBook();
                Student s = l.getStudent();
                Operator g1 = l.getGiverOperator();
                Operator g2 = l.getGetterOperator();
                ps.setString(1, b.getTitle());
                ps.setString(2, b.getAuthor());
                ps.setInt(3, b.getPublishYear());
                ps.setInt(4, b.getPages());
                ps.setInt(5, s.getSTUDENT_Id());
                ps.setString(6, s.getFirstName());
                ps.setString(7, s.getLastName());
                ps.setString(8, s.getDiscipline());
                ps.setString(9, s.getSignInDate().toString());
                ps.setInt(10, g1.getEMPLOYEE_ID());
                ps.setString(11, g1.getFirstName());
                ps.setString(12, g1.getLastName());
                ps.setInt(13, 2);
                ps.setInt(14, g2.getEMPLOYEE_ID());
                ps.setString(15, g2.getFirstName());
                ps.setString(16, g2.getLastName());
                ps.setInt(17, 2);
                ps.setString(18, l.getLoanStartDate().toString());
                ps.setString(19, l.getLoanEndDate().toString());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            System.out.println("Error saving library: " + e.getMessage());
        }
    }

    @Override
    public Library loadLibrary() {
        String libraryName = "MyLibrary";
        LibraryManager manager = null;
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Operator> operators = new ArrayList<>();
        ArrayList<LoanBook> loans = new ArrayList<>();
        ArrayList<StudentsLoanBookRequest> loanRequests = new ArrayList<>();
        ArrayList<LoanBook> returnRequests = new ArrayList<>();

        try (Connection conn = connect()) {
            Statement stmt = conn.createStatement();

            // Manager
            ResultSet rs = stmt.executeQuery("SELECT * FROM LibraryManager");
            if (rs.next())
                manager = new LibraryManager(rs.getString(1), rs.getString(2), rs.getString(3));

            // Books
            rs = stmt.executeQuery("SELECT * FROM Books");
            while (rs.next())
                books.add(new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));

            // Students
            rs = stmt.executeQuery("SELECT * FROM Students");
            while (rs.next())
                students.add(new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5)));

            // Operators
            rs = stmt.executeQuery("SELECT * FROM Operators");
            while (rs.next())
                operators.add(new Operator(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));

            // Loans
            rs = stmt.executeQuery("SELECT * FROM Loans");
            while (rs.next()) {
                Book b = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                Student s = new Student(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                Operator g1 = new Operator(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                Operator g2 = new Operator(rs.getInt(14), rs.getString(15), rs.getString(16), rs.getInt(17));
                loans.add(new LoanBook(b, s, g1, g2, rs.getString(18), rs.getString(19)));
            }

            // LoanRequests
            rs = stmt.executeQuery("SELECT * FROM LoanRequests");
            while (rs.next()) {
                Student s = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                Book b = new Book(rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9));
                loanRequests.add(new StudentsLoanBookRequest(s, b, rs.getString(10)));
            }

            // ReturnRequests
            rs = stmt.executeQuery("SELECT * FROM ReturnRequests");
            while (rs.next()) {
                Book b = new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
                Student s = new Student(rs.getInt(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                Operator g1 = new Operator(rs.getInt(10), rs.getString(11), rs.getString(12), rs.getInt(13));
                Operator g2 = new Operator(rs.getInt(14), rs.getString(15), rs.getString(16), rs.getInt(17));
                returnRequests.add(new LoanBook(b, s, g1, g2, rs.getString(18), rs.getString(19)));
            }

        } catch (SQLException e) {
            System.out.println("Error loading library: " + e.getMessage());
        }

        return new Library(libraryName, manager, books, students, operators, loans, loanRequests, returnRequests);
    }
}

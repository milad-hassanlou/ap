package ap.exercises.ex3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Student {
    public String firstName;
    public String lastName;
    public int studentNumber;
    public String studyField;
}

public class Main_EX3_LM_1_3 {

    static int isStudentInList(Student[] studentArr, String firstName, String lastName) {
        String referenceFirstName = null;
        String referenceLastName = null;
        firstName = firstName.toLowerCase();
        lastName = lastName.toLowerCase();

        for (int i = 0; i < studentArr.length; i++) {
            referenceFirstName = studentArr[i].firstName.toLowerCase();
            referenceLastName = studentArr[i].lastName.toLowerCase();
            if (referenceFirstName.equals(firstName) && referenceLastName.equals(lastName)) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) throws FileNotFoundException {

        //Reading Students Array Information From File

        File fileStudent = new File("E:/Codings Related Files/Temp/TempFilesInCodes/studentsSaveFile(Main_EX3_LM_1_2).txt");
        Scanner getStudent = new Scanner(fileStudent);
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].firstName = getStudent.nextLine();
            students[i].lastName = getStudent.nextLine();
            students[i].studentNumber = getStudent.nextInt();
            getStudent.nextLine();
            students[i].studyField = getStudent.nextLine();
        }
        getStudent.close();

        //Get Student Name From User
        Scanner get = new Scanner(System.in);
        System.out.println("Please Input Student information:");
        System.out.print("FirstName:");
        String targetFirstName = get.nextLine();
        System.out.print("LastName:");
        String targetLastName = get.nextLine();

        //Print Results
        int foundIndex = isStudentInList(students, targetFirstName, targetLastName);
        if (foundIndex != -1) {
            System.out.println("Student Found in List. Information:");
            System.out.println("First Name: " + students[foundIndex].firstName);
            System.out.println("Last Name: " + students[foundIndex].lastName);
            System.out.println("Student Number: " + students[foundIndex].studentNumber);
            System.out.println("Study Field: " + students[foundIndex].studyField);
            System.out.println();
        } else {
            System.out.printf("No Student with FIRSTNAME: %s, LASTNAME: %s Found!", targetFirstName, targetLastName);
        }
    }
}

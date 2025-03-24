package ap.exercises.ex1;

import java.util.Scanner;

public class Main_E6_3 {
    public static void main(String[] args) {
        System.out.print("Please input a line:");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int ln = str.length();

        //Directly [ 65<=str.charAt(i) && str.charAt(i)<=90 ] could be used inside the if statement which works by ASCII or better to say UNiCode chars tables.
        System.out.print("All UpperCase Characters:");
        for (int i = 0; i < ln; i++) {
            if (Character.isUpperCase(str.charAt(i))) {
                System.out.print(" " + str.charAt(i));
            }
        }

        System.out.print("\nEvery second letters:");
        for (int i = 1; i < ln; i += 2) {
            if (str.charAt(i) == ' ') {
                System.out.print(" " + "~");
            } else {
                System.out.print(" " + str.charAt(i));
            }
        }

        System.out.print("\nString with replaced vowels:");
        char ch;
        char[] chArr = str.toCharArray();
        int countVowels = 0;
        for (int i = 0; i < ln; i++) {
            ch = Character.toLowerCase(chArr[i]);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                chArr[i] = '_';
                countVowels++;
            }
        }
        System.out.println(chArr);
        System.out.println("Number of vowels in String:" + countVowels);

        System.out.print("Position of all vowels in string:");
        for (int i = 0; i < ln; i++) {
            ch = Character.toLowerCase(str.charAt(i));
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.print(" " + i);
            }
        }

    }
}

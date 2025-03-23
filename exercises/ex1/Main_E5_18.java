package exercises.ex1;

import java.util.Scanner;

public class Main_E5_18 {
    public static void main(String[] args) {
        String[] str = new String[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Please input three strings: ");
        for (int i = 0; i < 3; i++) {
            str[i] = input.next();
        }
        for (int i = 3; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (str[j].compareTo(str[j + 1]) > 0) {
                    String temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(str[i]);
        }
    }
}

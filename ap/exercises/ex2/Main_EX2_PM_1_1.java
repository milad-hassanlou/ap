package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_1_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input an integer number for the size of game-field:");
        int k = in.nextInt();

        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || j == 0 || i == k + 1 || j == k + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

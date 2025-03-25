package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_3 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please input an integer number for the size of game-field:");
        int k = in.nextInt();

        char[][] field = new char[k + 2][k + 2];

        //Determine Game-Field Frame By "*"
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || j == 0 || i == k + 1 || j == k + 1) {
                    field[i][j] = '*';
                } else {
                    field[i][j] = ' ';
                }
            }
        }

        //Determine Foods In Game By "."
        int c = 0;
        while (true) {
            System.out.print("Please input an integer number for the number of foods in the game:");
            c = in.nextInt();
            if (c > k * k) {
                System.out.println("Invalid!..The number is larger than field space. retry: ");
            } else {
                break;
            }
        }

        Random rand = new Random();
        int count = 0;
        while (count < c) {
            int iRandom = rand.nextInt(k + 2);
            int jRandom = rand.nextInt(k + 2);
            if (field[iRandom][jRandom] == ' ') {
                field[iRandom][jRandom] = '.';
                count++;
            }
        }

        //Print Game-Field
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        //Close Classes
        in.close();
    }
}

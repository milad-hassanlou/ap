package ap.exercises.ex2;

import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_1_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input an integer number for the size of game-field:");
        int k = input.nextInt();

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

        //Determine PACMAN Position in the Game-Field
        int iPacman = 1;
        int jPacman = 1;
        field[iPacman][jPacman] = 'X';

        //Print the Basic Game-Field
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }

        int iNewPacman = iPacman;
        int jNewPacman = jPacman;
        int randomNum;
        Random rand = new Random();
        while (true) {
            randomNum = rand.nextInt(4);
            switch (randomNum) {
                case 0:
                    System.out.println("UP");
                    iNewPacman = iPacman - 1;
                    jNewPacman = jPacman;
                    break;
                case 1:
                    System.out.println("RIGHT");
                    iNewPacman = iPacman;
                    jNewPacman = jPacman + 1;
                    break;
                case 2:
                    System.out.println("DOWN");
                    iNewPacman = iPacman + 1;
                    jNewPacman = jPacman;
                    break;
                case 3:
                    System.out.println("LEFT");
                    iNewPacman = iPacman;
                    jNewPacman = jPacman - 1;
                    break;
            }

            if (field[iNewPacman][jNewPacman] == '*') {
                System.out.println("!!hitting the game wall!!");

            } else {
                field[iPacman][jPacman] = ' ';
                iPacman = iNewPacman;
                jPacman = jNewPacman;
                field[iPacman][jPacman] = 'X';

                //Print the Game-Field
                for (int i = 0; i < k + 2; i++) {
                    for (int j = 0; j < k + 2; j++) {
                        System.out.print(field[i][j]);
                    }
                    System.out.println();
                }

            }

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }

        }
    }
}


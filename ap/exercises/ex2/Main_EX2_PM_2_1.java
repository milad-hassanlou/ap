package ap.exercises.ex2;

import java.util.Scanner;

public class Main_EX2_PM_2_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //Determine Game-Field Size
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

        //Get Direction and Move Pacman
        int iNewPacman = iPacman;
        int jNewPacman = jPacman;

        while (true) {
            String inputDirection = input.next();
            inputDirection = inputDirection.toLowerCase();
            switch (inputDirection) {
                case "w":
                    System.out.println("UP");
                    iNewPacman = iPacman - 1;
                    jNewPacman = jPacman;
                    break;
                case "d":
                    System.out.println("RIGHT");
                    iNewPacman = iPacman;
                    jNewPacman = jPacman + 1;
                    break;
                case "s":
                    System.out.println("DOWN");
                    iNewPacman = iPacman + 1;
                    jNewPacman = jPacman;
                    break;
                case "a":
                    System.out.println("LEFT");
                    iNewPacman = iPacman;
                    jNewPacman = jPacman - 1;
                    break;
                case "q":
                    System.out.println("EXIT");
                    input.close();
                    return;
                default:
                    System.out.println("WARNING");
            }
            if (inputDirection.equals("w") || inputDirection.equals("d") || inputDirection.equals("s") || inputDirection.equals("a")) {
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
            }
        }
    }
}


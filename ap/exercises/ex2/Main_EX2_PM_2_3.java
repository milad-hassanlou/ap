package ap.exercises.ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Main_EX2_PM_2_3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        //Main Variables
        String fileAddress = "ap/exercises/ex2/javaPacmanInCodeSaveFile(EX2_PM_2_3).txt";
        int k;
        int c;
        int score = 0;
        int iPacman;
        int jPacman;
        long startTime;
        long elapsedTimeSavedInFile = 0;
        char[][] fields;


        //Loading Saved Game if it Exists
        File savedFile = new File(fileAddress);
        if (savedFile.exists()) {
            System.out.println("Previous Game loaded...");
            Scanner getSave = new Scanner(savedFile);
            k = getSave.nextInt();
            c = getSave.nextInt();
            score = getSave.nextInt();
            iPacman = getSave.nextInt();
            jPacman = getSave.nextInt();
            elapsedTimeSavedInFile = getSave.nextLong();
            fields = new char[k + 2][k + 2];
            String str;
            getSave.nextLine();
            for (int i = 0; i < k + 2; i++) {
                str = getSave.nextLine();
                fields[i] = str.toCharArray();
            }
            startTime = System.currentTimeMillis();
            getSave.close();

        } else {
            System.out.println("New Game Created...");
            //Determine Game-Field Size
            System.out.print("Please input an integer number for the size of game-field:");
            k = input.nextInt();

            //set start time
            startTime = System.currentTimeMillis();

            fields = new char[k + 2][k + 2];

            //Determine Game-Field Frame By "*"
            for (int i = 0; i < k + 2; i++) {
                for (int j = 0; j < k + 2; j++) {
                    if (i == 0 || j == 0 || i == k + 1 || j == k + 1) {
                        fields[i][j] = '*';
                    } else {
                        fields[i][j] = ' ';
                    }
                }
            }

            //Determine PACMAN Position in the Game-Field
            iPacman = 1;
            jPacman = 1;
            fields[iPacman][jPacman] = 'X';

            //Determine Foods In Game By "."
            while (true) {
                System.out.print("Please input an integer number for the number of foods in the game:");
                c = input.nextInt();
                if (c >= k * k) {
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
                if (fields[iRandom][jRandom] == ' ') {
                    fields[iRandom][jRandom] = '.';
                    count++;
                }
            }
        }

        //Print the Basic Game-Field
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(fields[i][j]);
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
                    System.out.println("Game Saved & EXIT");
                    long savingTime = System.currentTimeMillis();
                    long elapsedTimeTillSaving = savingTime - startTime;
                    //Saving Fields
                    PrintWriter save = new PrintWriter(fileAddress);
                    save.println(k);
                    save.println(c);
                    save.println(score);
                    save.println(iPacman);
                    save.println(jPacman);
                    save.println(elapsedTimeTillSaving + elapsedTimeSavedInFile);
                    for (int i = 0; i < k + 2; i++) {
                        for (int j = 0; j < k + 2; j++) {
                            save.print(fields[i][j]);
                        }
                        save.println();
                    }
                    save.close();
                    input.close();
                    return;
                default:
                    System.out.println("WARNING");
            }
            if (inputDirection.equals("w") || inputDirection.equals("d") || inputDirection.equals("s") || inputDirection.equals("a")) {

                if (fields[iNewPacman][jNewPacman] == '*') {
                    System.out.println("!!hitting the game wall!!");
                } else {
                    if (fields[iNewPacman][jNewPacman] == '.') {
                        score++;
                    }
                    fields[iPacman][jPacman] = ' ';
                    iPacman = iNewPacman;
                    jPacman = jNewPacman;
                    fields[iPacman][jPacman] = 'X';

                    //Print the Game-Field
                    for (int i = 0; i < k + 2; i++) {
                        for (int j = 0; j < k + 2; j++) {
                            System.out.print(fields[i][j]);
                        }
                        System.out.println();
                    }

                    if (score == c) {
                        //set finish time
                        long finishTime = System.currentTimeMillis();
                        System.out.println("Game Completed!");
                        System.out.println("Score:" + score);
                        long elapsedTotalTime = (finishTime - startTime) + elapsedTimeSavedInFile;
                        System.out.println("Elapsed Time: " + elapsedTotalTime + " (milliseconds)");
                        savedFile.delete();
                        input.close();
                        return;
                    }
                }
            }
        }
    }
}
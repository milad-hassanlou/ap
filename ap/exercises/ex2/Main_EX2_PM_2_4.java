package ap.exercises.ex2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//In the Sending code the class name is pacmanEngine but here it's named Main_EX2_PM_2_4 due to GitUp management.

public class Main_EX2_PM_2_4 {
    private int k;
    private int c;
    private char[][] fields;
    private int iPacman;
    private int jPacman;
    private int iNewPacman;
    private int jNewPacman;
    private int score = 0;
    private long startTime;
    private long finishTime;
    private long elapsedTime;
    private final String address = "E:/Codings Related Files/Temp/TempFilesInCodes/javaPacmanInCodeSaveFile(EX2_PM_2_4).txt";

    public Main_EX2_PM_2_4(int k, int c) {
        startTime = System.currentTimeMillis();
        this.k = k;
        this.c = c;
        this.fields = new char[k + 2][k + 2];
        designGameField();

    }

    private void designGameField() {
        //Determine Game-Field Frame
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                if (i == 0 || i == k + 1 || j == 0 || j == k + 1) {
                    fields[i][j] = '*';
                } else {
                    fields[i][j] = (' ');
                }
            }
        }

        //Determine Pacman Position
        iPacman = 1;
        jPacman = 1;
        fields[iPacman][jPacman] = 'X';

        //Determine Foods Position
        Random rand = new Random();
        int count = 0;
        int iRandom;
        int jRandom;
        while (count < c) {
            iRandom = rand.nextInt(k + 2);
            jRandom = rand.nextInt(k + 2);
            if (fields[iRandom][jRandom] == ' ') {
                fields[iRandom][jRandom] = '.';
                count++;
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                System.out.print(fields[i][j]);
            }
            System.out.println();
        }
    }

    public void printScore() {
        System.out.println("Score:" + score);
    }

    public void printRemainTime() {
        finishTime = System.currentTimeMillis();
        elapsedTime = finishTime - startTime;
        System.out.println("Time:" + elapsedTime);
    }

    public void move(int direction) {
        switch (direction) {
            case 0:
                System.out.println("UP");
                iNewPacman = iPacman - 1;
                jNewPacman = jPacman;
                break;
            case 1:
                System.out.println("Right");
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
        }
        if (score == c) {
            System.out.println("The Game Finished!");
            System.exit(0);
        }
    }

    public void save() throws FileNotFoundException {
        PrintWriter save = new PrintWriter(address);
        save.println(k);
        save.println(c);
        save.println(score);
        save.println(iPacman);
        save.println(jPacman);
        save.println(elapsedTime);
        for (int i = 0; i < k + 2; i++) {
            for (int j = 0; j < k + 2; j++) {
                save.print(fields[i][j]);
            }
            save.println();
        }
        save.close();
    }
}

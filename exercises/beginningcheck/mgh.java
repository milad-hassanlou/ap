package exercises.beginningcheck;

import java.util.Scanner;

public class mgh {
    public static void main(String[] args) {
        final double g = 9.81;

        Scanner scanner = new Scanner(System.in);

        System.out.print(" math (kg): ");
        double mass = scanner.nextDouble();


        System.out.print(" hight (m): ");
        double height = scanner.nextDouble();


        double energy = mass * g * height;


        System.out.println("W:" + energy);

        scanner.close();
    }
}




package exercises.ex1;

import java.util.Scanner;

//The question defined out class name as Dataset but for GitHub better order I preferred E6_5
public class Main_E6_5 {
    static double sum = 0;
    static int count = 0;
    static double min = Double.MAX_VALUE;
    static double max = Double.MIN_VALUE;

    public static void main(String[] args) {
        System.out.print("please input floating point numbers:");
        Scanner in = new Scanner(System.in);
        while (in.hasNextDouble()) {
            double doubleScanned = in.nextDouble();
            add(doubleScanned);
            min(doubleScanned);
            max(doubleScanned);
        }
        System.out.println("Details: ");
        System.out.printf("Average of Values: %.2f \n", getAverage());
        System.out.println("The Smallest of Values: " + min);
        System.out.println("The Largest of Values: " + max);
        System.out.printf("The Range of Values:%.2f \n", getRange());

    }

    static void add(double dNum) {
        sum += dNum;
        count++;
    }

    static void max(double dNumber) {
        if (max < dNumber) {
            max = dNumber;
        }
    }

    static void min(double doubleNum) {
        if (min > doubleNum) {
            min = doubleNum;
        }
    }

    static double getAverage() {
        return sum / count;
    }

    static double getRange() {
        return max - min;
    }
}



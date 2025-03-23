package exercises.ex1;

import java.util.Scanner;

public class Main_E6_1_E {
    public static void main(String[] args) {
        System.out.print("Please input a number:");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int originalNum = num;
        int sum = 0;
        int r;
        while (num > 0) {
            r = num % 10;
            if (r % 2 == 1) {
                sum += r;
            }
            num /= 10;
        }
        System.out.printf("Summation of odd digits of %d is %d.", originalNum, sum);
    }
}

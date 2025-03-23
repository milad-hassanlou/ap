package exercises.ex1;

import java.util.Scanner;

public class Main_E6_2_C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers (Separate them with one Space):");

        String str = in.nextLine();
        String[] arrStr = str.split(" ");

        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.print("Cumulative Totals:");
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.print(sum + " ");
        }
    }

}

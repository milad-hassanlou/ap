package exercises.ex1;

import java.util.Scanner;

public class Main_E6_2_A {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers (Separate them with one Space):");

        String str = in.nextLine();
        String[] arrStr = str.split(" ");

        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        int max = nums[0], min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }

            if (nums[i] < min) {
                min = nums[i];
            }
        }
        System.out.println("Maximum input: " + max);
        System.out.println("Minimum input: " + min);

    }
}

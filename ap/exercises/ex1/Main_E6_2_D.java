package ap.exercises.ex1;

import java.util.Scanner;

public class Main_E6_2_D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers (Separate them with one Space):");

        String str = in.nextLine();
        String[] arrStr = str.split(" ");

        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        System.out.print("adjacent duplicates:");
        boolean isPrinted = false;
        boolean anyThingPrinted = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (!isPrinted) {
                    System.out.print(" " + nums[i]);
                    anyThingPrinted = true;
                    isPrinted = true;
                }
            } else {
                isPrinted = false;
            }
        }
        if (!anyThingPrinted) {
            System.out.print("No duplicates");
        }
    }
}

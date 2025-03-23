package exercises.ex1;

import java.util.Scanner;

public class Main_E6_2_B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers (Separate them with one Space):");

        String str = in.nextLine();
        String[] arrStr = str.split(" ");

        int[] nums = new int[arrStr.length];
        for (int i = 0; i < arrStr.length; i++) {
            nums[i] = Integer.parseInt(arrStr[i]);
        }
        int oddCount = 0, evenCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        System.out.println("Number of Even numbers: " + evenCount);
        System.out.println("Number of Odd numbers: " + oddCount);

    }
}

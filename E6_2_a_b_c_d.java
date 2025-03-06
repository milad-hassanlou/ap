import java.util.Scanner;

public class E6_2_a_b_c_d {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter numbers (Separate them with one Space):");
        // This below lines developed to get numbers without asking user to define the number of numbers.
        // This lines together work out creating an Array without defining number of elements of it.

        String str = in.nextLine();
        String[] arrStr = str.split(" ");

        // change numbers from string form to integer:  int a = Integer.parseInt("String");
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

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.print(sum + " ");
        }


        System.out.print("\nadjacent duplicates:");
        boolean isPrinted = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                if (!isPrinted)
                    System.out.print(" " + nums[i] );
                isPrinted = true;
            } else {
                isPrinted = false;
            }
        }
    }
}

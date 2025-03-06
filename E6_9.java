import java.util.Scanner;

public class E6_9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please input a word:");
        String word = input.next();
        int ln = word.length();
        char[] arr = new char[ln];
        for (int i = 0; i < ln; i++) {
            arr[ln - 1 - i] = word.charAt(i);
        }
        System.out.println("Reversed of Word: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}

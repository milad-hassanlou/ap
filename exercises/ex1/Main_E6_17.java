package exercises.ex1;

import java.util.Scanner;

public class Main_E6_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a number:");
        int num = in.nextInt();
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < 2*num+1; j++) {
                if (j==num||((i!=0 && i!=num-1) && (num+1<j && j<2*num))){
                    System.out.print(" ");
                }else{
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
}

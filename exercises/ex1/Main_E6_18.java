package exercises.ex1;

import java.util.Scanner;

public class Main_E6_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a number:");
        int n= in.nextInt();
        for (int i=0;i<n;i++){
            for(int j=0;j<2*n-1;j++) {
                if (n-1-i<=j && j<=n-1+i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        for (int i = 0; i <n-1; i++) {
            for (int j = 0; j < 2*n-1;j++) {
                if(i<j && j<2*n-2-i){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

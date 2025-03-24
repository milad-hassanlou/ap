package ap.exercises.ex1;

import java.util.Scanner;

public class Main_E6_13 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.print("Please input your number:");
        int num=in.nextInt();
        System.out.println("Binary form of the number:");
        while(num>0){
            System.out.println(num%2);
            num/=2;
        }
    }
}

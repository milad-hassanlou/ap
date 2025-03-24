package ap.exercises.ex1;

import java.util.Scanner;

public class Main_E6_8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please input a word:");
        String input = in.next();
        System.out.println("Characters: ");

        // First Way:
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i));
        }
        /*

        //Second Way:
        char[] ch=input.toCharArray();
        for(int i=0;i<ch.length;i++){
            System.out.println(ch[i]);
        }

        //third Way:
        String[] chBlock = input.split("");
        for(int i=0;i<chBlock.length;i++){
        System.out.println(chBlock[i]);
        }

        */
    }
}

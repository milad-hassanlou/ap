import java.util.Scanner;
public class E5_2 {
    public static void main(String[] args){
        System.out.print("Please input a number: ");
        Scanner in = new Scanner(System.in);
        float num = in.nextFloat();
        if(num==0)
        {
            System.out.println("Zero");
        }
        else if(num>0)
        {
            System.out.println("Positive");
        }
        else
        {
            System.out.println("Negative");
        }
        if(Math.abs(num)<1)
        {
            System.out.println("Small");
        }
        else if(Math.abs(num)>1_000_000)
        {
            System.out.println("Large");
        }
        in.close();
    }

}

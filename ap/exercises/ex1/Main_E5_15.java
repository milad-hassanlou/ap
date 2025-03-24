package ap.exercises.ex1;

import java.util.Scanner;
public class Main_E5_15 {
    public static void main(String[] args){
        float tax = 10;
        System.out.print("Please input your salary: ");
        Scanner input=new Scanner(System.in);
        int salary=input.nextInt();
        if(salary<50_000){
            tax=(float)(0.01)*salary;
        } else if (salary<75_000) {
            tax =(float) ((0.01) * 50_000 + (0.02) * (salary - 50_000));
        }else if (salary<100_000) {
            tax = (float) ((0.01) * 50_000 + (0.02) * 25_000 + (0.03) * (salary - 75_000));
        }else if(salary<250_000) {
            tax = (float)((0.01) * 50_000 + (0.02) * 25_000 + (0.03) * 25_000 + (0.04) * (salary - 100));
        }else if(salary<500_000) {
            tax = (float)((0.01) * 50_000 + (0.02) * 25_000 + (0.03) * 25_000 + (0.04) * 150_000+ (0.05) * (salary - 250_000));
        }else if(salary>500_000) {
            tax = (float)((0.01) * 50_000 + (0.02) * 25_000 + (0.03) * 25_000 + (0.04) * 150_000 + (0.05) * 250_000 + (0.06) * (salary - 500_000));
        }
        System.out.println("Tax amount: " + tax);
        System.out.println("Net salary after tax payment: " + salary + tax);
    }
}

package ap.exercises.ex1;

public class Main_E6_1_A {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 3; i < 100; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}

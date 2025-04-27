package ap.exercises.ex4;

public class Main_EX4_E3_5 {
    public static void main(String[] args) {
        Main_EX4_E3_4 h1 = new Main_EX4_E3_4(0,0);
        int stateCount = 1;
        for(int i =0;i<2;i++){
            for(int j=0;j<2; j++){
                int predictedLampState = i==j?0:1;
                System.out.println("State: " + stateCount);
                System.out.println("First Switch State: " + "Predicted:" + i + " Actual:" + h1.getFirstSwitchState());
                System.out.println("Second Switch State: " + "Predicted:" + j + " Actual:" + h1.getSecondSwitchState());
                System.out.println("LampState: " + "Predicted:" + predictedLampState + " Actual:" + h1.getLampState());
                System.out.println();
                h1.toggleSecondSwitch();
                stateCount++;
            }
            h1.toggleFirstSwitch();
        }
    }
}
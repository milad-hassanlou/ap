package ap.exercises.ex4;

public class Main_EX4_E3_6 {
    private int[] stateOfSwitch;
    private int lampState;

    public Main_EX4_E3_6(){
        stateOfSwitch=new int[]{0,0};
        lampState =0;
    }

    public Main_EX4_E3_6(int firstSwitchState, int secondSwitchState){
        stateOfSwitch = new int[]{firstSwitchState,secondSwitchState};

    }

    public int getSwitchState(int switchNum) {
        return stateOfSwitch[switchNum];
    }

    public int getLampState() {
        if (stateOfSwitch[0] == stateOfSwitch[1]) {
            lampState = 0;
        } else {
            lampState = 1;
        }
        return lampState;
    }

    public void toggleSwitch(int switchNum) {
        if (stateOfSwitch[switchNum] == 0) {
            stateOfSwitch[switchNum] = 1;
        } else {
            stateOfSwitch[switchNum] = 0;
        }
    }
}

//Testing Above code (Optional)
/*
public class Main_EX4_E3_6_TESTING {
    public static void main(String[] args) {
        Main_EX4_E3_6 h1 = new Main_EX4_E3_6(0,0);
        int stateCount = 1;
        for(int i =0;i<2;i++){
            for(int j=0;j<2; j++){
                int predictedLampState = i==j?0:1;
                System.out.println("State: " + stateCount);
                System.out.println("First Switch State: " + "Predicted:" + i + " Actual:" + h1.getSwitchState(0));
                System.out.println("Second Switch State: " + "Predicted:" + j + " Actual:" + h1.getSwitchState(1));
                System.out.println("LampState: " + "Predicted:" + predictedLampState + " Actual:" + h1.getLampState());
                System.out.println();
                h1.toggleSwitch(1);
                stateCount++;
            }
            h1.toggleSwitch(0);
        }
    }
}
 */
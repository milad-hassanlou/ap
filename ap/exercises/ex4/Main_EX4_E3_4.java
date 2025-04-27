package ap.exercises.ex4;

public class Main_EX4_E3_4 {
    private int firstSwitchState ;
    private int secondSwitchState ;
    private int lampState;

    public Main_EX4_E3_4(){
        this.firstSwitchState = 0;
        this.secondSwitchState = 0;
        this.lampState =0;
    }

    public Main_EX4_E3_4(int firstSwitchState, int secondSwitchState){
        this.firstSwitchState=firstSwitchState;
        this.secondSwitchState=secondSwitchState;
    }

    public int getFirstSwitchState() {
        return firstSwitchState;
    }

    public int getSecondSwitchState() {
        return secondSwitchState;
    }

    public int getLampState() {
        if (firstSwitchState == secondSwitchState) {
            lampState = 0;
        } else {
            lampState = 1;
        }
        return lampState;
    }

    public void toggleFirstSwitch() {
        if (firstSwitchState == 0) {
            firstSwitchState = 1;
        } else {
            firstSwitchState = 0;
        }
    }

    public void toggleSecondSwitch() {
        if (secondSwitchState == 0) {
            secondSwitchState = 1;
        } else {
            secondSwitchState = 0;
        }
    }
}

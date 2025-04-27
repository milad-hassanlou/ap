package ap.exercises.ex4;

public class Main_EX4_E3_15 { //Letter
    private String from;
    private String to;
    private String body;

    public Main_EX4_E3_15(String from, String to) {
        this.from = from;
        this.to = to;
        this.body = "";
    }

    public void addLine(String line) {
        body = body + line + "\n";
    }

    public String getText() {
        return "Dear " + to + ": \n\n" + body + "\n" + "Sincerely," + "\n\n" + from;
    }
}


class LetterPrinter {
    public static void main(String[] args) {
        Main_EX4_E3_15 letter1 = new Main_EX4_E3_15("Mary", "John");
        letter1.addLine("I am sorry we must part.");
        letter1.addLine("I wish you all the best");
        System.out.println(letter1.getText());
    }
}

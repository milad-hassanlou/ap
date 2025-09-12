package ap.exercises.finalexam;

public class Pen extends Product {
    private final Color color;

    public Pen(String name, int price, Color color) {
        super(name, price);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + " Color: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Pen pen = (Pen) obj;
        return pen.getName().equals(this.getName()) && pen.getPrice() == this.getPrice() && pen.color == this.color;
    }
}

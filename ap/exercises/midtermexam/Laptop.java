package ap.exercises.midtermexam;

public class Laptop extends Product {
    private float weight;
    private String color;

    public Laptop(String brand ,int price, float weight, String color) {
        super(brand,price);
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString()+"Weight: " + weight + "color: " + color;
    }

}

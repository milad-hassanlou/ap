package ap.exercises.examquestionAfterDiscount;

public class Pen {
    private String color;
    private String brand;
    private int price;
    private int off;

    public Pen(String color, String brand, int price, int off) {
        this.color = color;
        this.brand = brand;
        this.price = price;
        this.off = off;
    }

    public String getInfo() {
        int newPrice = price-(price*off/100);
        String output = color + "\t" + brand + "\t" + newPrice;
        return output;
    }
}

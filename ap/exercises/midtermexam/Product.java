package ap.exercises.midtermexam;

public class Product {
    private String brand;
    private int price;

    public Product(String brand, int price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Brand: " + brand + "Price: " + price ;
    }
}

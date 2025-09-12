package ap.exercises.finalexam;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Price: " + price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}

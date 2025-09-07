package ap.exercises.finalexam;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Product> productList = new ArrayList<>();
        productList.add(new Book("Notelet", 1000, "Eng text", "Michel"));
        productList.add(new Book("Booki", 2000, "Math", "Tomas"));
        productList.add(new Pen("Panter", 1000, Color.Blue));
        productList.add(new Pen("Owner", 800, Color.Black));
        productList.add(new Book("Booki", 2000, "Math", "Tomas"));
        productList.add(new Pen("Owner", 800, Color.Black));
        productList.add(new Pen("Panter", 1000, Color.Blue));
        ProductTools.printSorted(productList);
    }
}

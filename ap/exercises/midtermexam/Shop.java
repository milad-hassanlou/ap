package ap.exercises.midtermexam;

import java.util.ArrayList;

public class Shop {
    private ArrayList<Product> productList = new ArrayList<>();

    public void addProduct(Product product){
        productList.add(product);
    }

    public void printProducts(){
        for(Product product: productList){
            System.out.println(product);
        }
    }
}

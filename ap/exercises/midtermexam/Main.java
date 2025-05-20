package ap.exercises.midtermexam;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.addProduct(new Laptop("Asus",1000,5.5f,"Black"));
        shop.addProduct(new Case("Dell",2000,"Green",2024));
        shop.printProducts();
    }
}

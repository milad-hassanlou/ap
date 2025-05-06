package ap.exercises.examquestionAfterDiscount;

public class Book {
    private String name;
    private int price;
    private int off;

    public Book(String name, int price, int off) {
        this.name = name;
        this.price = price;
        this.off = off;
    }

    public String getInfo() {
        int newPrice = price-(price*off/100);
        String output = name + "\t" + newPrice;
        return output;
    }
}

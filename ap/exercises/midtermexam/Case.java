package ap.exercises.midtermexam;

public class Case extends Product {
    private String color;
    private int publishYear;

    public Case(String brand , int price ,String color, int publishYear) {
        super(brand,price);
        this.color = color;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return super.toString()+ "Color: " + color + "PublishYear: " + publishYear;
    }

}

package ap.exercises.examquestionAfterDiscount;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pen> penList = new ArrayList<>();
        penList.add(new Pen("...", "...", 200,10));
        penList.add(new Pen("...", "...", 30,20));

        ArrayList<Book> bookList = new ArrayList<>();
        bookList.add(new Book("...", 400,50));
        bookList.add(new Book("...", 500,30));

        System.out.println("Pens:");
        for (Pen unit : penList) {
            System.out.println(unit.getInfo());
        }

        System.out.println("Books:");
        for (Book unit : bookList) {
            System.out.println(unit.getInfo());
        }
    }
}

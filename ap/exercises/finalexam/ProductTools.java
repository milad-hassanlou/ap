package ap.exercises.finalexam;

import java.util.List;

public class ProductTools {

    public static void printSorted(List<Product> products) {
        products.stream()
                .distinct()
                .sorted((a, b) -> {
                    if (a.getPrice() > b.getPrice()) {
                        return 1;
                    } else if (a.getPrice() == b.getPrice()) {
                        if (b.getClass() == Book.class) {
                            return 1;
                        }
                    }
                    return -1;
                })
                .forEach(p -> System.out.println(p));
    }
}

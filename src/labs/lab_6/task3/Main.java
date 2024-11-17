package labs.lab_6.task3;

import labs.lab_6.task3.entity.Product;
import labs.lab_6.task3.service.ProductService;

public class Main {

    public static void main(String[] args) {
        ProductService productService = new ProductService();

        Product cola = new Product(1L, "cola", 20, 100);
        Product pizza = new Product(2L, "pizza", 30, 200);
        Product water = new Product(3L, "water", 100, 40);
        Product fanta = new Product(4L, "fanta", 40, 98);

        productService.save(cola);
        productService.save(pizza);
        productService.save(water);
        productService.save(fanta);

        System.out.println(productService.getAll());

        productService.sell(cola, 5);
        productService.sell(fanta, 10);
        productService.sell(water, 30);
        productService.sell(cola, 10);

        System.out.println(productService.getAll());

        System.out.println(productService.getSoldProducts().toString());

        System.out.println(productService.getCountSoldProducts().toString());

    }
}

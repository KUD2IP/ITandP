package labs.lab_7.task3;

import labs.lab_7.task3.entity.Loader;
import labs.lab_7.task3.entity.Product;
import labs.lab_7.task3.entity.Warehouse;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Warehouse warehouse = new Warehouse(new ArrayList<>(
                Arrays.asList(
                        new Product("Молоко", 40),
                        new Product("Сыр",40),
                        new Product("Вода",30),
                        new Product("Хлеб", 25),
                        new Product("Колбаса",10),
                        new Product("Конфеты",20),
                        new Product("Мороженое",150)
                )
        ));

        Loader loader1 = new Loader(warehouse);
        Loader loader2 = new Loader(warehouse);
        Loader loader3 = new Loader(warehouse);

        loader1.start();
        loader2.start();
        loader3.start();

    }
}

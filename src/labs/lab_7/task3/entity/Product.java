package labs.lab_7.task3.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private int weight;

    public Product(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
}

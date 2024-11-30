package labs.lab_7.task3.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Warehouse {
    private List<Product> products;
    private final int maxTotalWeight = 150;
    private int totalWeight = 0;

    public Warehouse(List<Product> products) {
        this.products = products;
    }

    public synchronized Product takeProduct(){
        if (!products.isEmpty() && totalWeight < maxTotalWeight) {
            Product product = products.getFirst();
            if (totalWeight + product.getWeight() <= maxTotalWeight) {
                totalWeight += product.getWeight();
                products.removeFirst();
                return product;
            }
        }
        return null;
    }

    public synchronized int getTotalWeight() {
        return totalWeight;
    }
}

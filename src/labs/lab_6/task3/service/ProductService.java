package labs.lab_6.task3.service;

import labs.lab_6.task3.entity.Product;
import labs.lab_6.task3.repository.ProductDatabase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
public class ProductService {

    private ProductDatabase productDatabase = new ProductDatabase();

    public void save(Product product) {
        productDatabase.product.put(product.getId(), product);
    }

    public Product getById(long id) {
        return productDatabase.product.get(id);
    }

    public void deleteById(long id) {
        productDatabase.product.remove(id);
    }

    public String getAll() {
        StringBuilder sb = new StringBuilder("ID PRODUCT\n");

        for (Map.Entry<Long, Product> entry : productDatabase.product.entrySet()) {
            sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
        }

        return sb.toString();
    }

    public Product getByName(String name) {
        return productDatabase.product
                .values().stream().filter(o ->
                        o.getName().equals(name))
                .findFirst().orElse(null);
    }

    public void sell(Product product, int count) {
        product.setCount(product.getCount() - count);
        productDatabase.countSoldProducts.put(
                product.getName(),
                productDatabase.countSoldProducts
                        .getOrDefault(product.getName(), 0) + count);
        productDatabase.soldProducts.add(product.getName());
    }

    public ArrayList<String> getSoldProducts() {
        return productDatabase.soldProducts;
    }

    public Map<String, Integer> getCountSoldProducts() {
        return productDatabase.countSoldProducts;
    }
}

package labs.lab_6.task3.repository;

import labs.lab_6.task3.entity.Product;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class ProductDatabase {

    //Tables products
    public Map<Long, Product> product = new HashMap<>();

    //Tables soldProducts
    public ArrayList<String> soldProducts = new ArrayList<>();

    //Tables CountSoldProducts
    public Map<String, Integer> countSoldProducts = new HashMap<>();

}

package labs.lab_7.task3.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Loader extends Thread {

    private Warehouse warehouse;

    public Loader(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void run() {
        while (true) {
            Product product = warehouse.takeProduct();
            if (product != null) {
                System.out.println(
                                getName() + " Грузчик загрузил товар весом: "
                                + product.getWeight() + " кг, текущий общий вес: "
                                + warehouse.getTotalWeight() + " кг");
            } else {
                break;
            }
        }
        System.out.println(getName() + " закончил загрузку.");
    }
}

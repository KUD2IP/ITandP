package labs.lab_3;

import java.util.Date;

public class Orders {
    private String dishes;
    private int price;
    private String date;

    public Orders() {
    }

    public Orders(String dishes, int price, String date) {
        this.dishes = dishes;
        this.price = price;
        this.date = date;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "dishes='" + dishes + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}

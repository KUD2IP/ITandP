package labs.lab_2;

import labs.lab_2.gadgets.laptop.Asus;
import labs.lab_2.gadgets.smartphone.Apple;
import labs.lab_2.gadgets.smartphone.Xiaomi;
import labs.lab_2.gadgets.watch.Samsung;

public class Main {
    public static void main(String[] args) {

        Apple apple = new Apple(90, "Iphone 15 pro", "Black", 100_000);
        apple.charge();
        apple.on();
        apple.downloadApp("Vk", "Tg", "Instagram");
        System.out.println(apple.toString());

        Xiaomi xiaomi = new Xiaomi(89, "Xiaomi 12", "White", 50_000);
        xiaomi.charge();
        xiaomi.on();
        xiaomi.downloadApp("Vk", "Telegram", "Instagram");
        System.out.println(xiaomi.toString());

        Asus asus = new Asus(89, "TUF F15", 75_000);
        asus.charge();
        asus.on();
        asus.downloadOperatingSystem("Windows");
        System.out.println(asus.toString());

        Samsung samsung = new Samsung(89, 50_000, "Galaxy watch 5");
        samsung.charge();
        samsung.on();
        System.out.println(samsung.toString());
    }
}
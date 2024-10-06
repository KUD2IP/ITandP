package labs.lab_3;

import labs.lab_3.hash_table.HashTable;

import java.util.Date;
import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {

        //№ 1
        HashTable<Integer, String> hashtable1 = new HashTable<>();

        System.out.println(hashtable1.isEmpty());

        hashtable1.put(1, "a");
        hashtable1.put(2, "b");
        hashtable1.put(3, "c");

        System.out.println( hashtable1.get(2));

        hashtable1.remove(2);

        System.out.println(hashtable1.isEmpty());

        System.out.println(hashtable1.toString() + "\n");

        //№ 2
        Hashtable<Integer, Orders> hashtable2 = new Hashtable<>();

        hashtable2.put(1, new Orders("pasta, fries", 1000, "08.10.2024 19:00"));

        hashtable2.put(10, new Orders("burger, fries, soda, chips", 2500, "07.10.2024 13:00"));

        hashtable2.put(4, new Orders("soup, sandwich, wine", 3000, "08.10.2024 16:30"));

        System.out.println(hashtable2.get(4) + "\n");

        hashtable2.remove(4);

        System.out.println(hashtable2.toString());

    }
}

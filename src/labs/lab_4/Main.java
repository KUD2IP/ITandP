package labs.lab_4;

import labs.lab_4.Exception.CustomAgeException;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        Object[] arr = new Object[5];

        for (int i = 0; i < 15; i++) {
            Random r = new Random();
            int a = r.nextInt(1,10);
            try {
                arr[i] = a;
            }catch (IndexOutOfBoundsException e) {
                System.err.println("Индекс за пределами массива");
                break;
            }
        }

        int sum = 0;
        arr[3] = "hello";
        int len = arr.length;

        for (int i = 0; i < arr.length; i++) {

            try{
                sum += (int) arr[i];
                if (i == arr.length - 1) {
                    System.out.println((double) sum / len);
                }
            }catch (ClassCastException e) {
                System.err.println("Неверный тип данных");
                len--;
                continue;
            }
        }

        System.out.println(Arrays.toString(arr));

        try{
            FileReader file1 = new FileReader("src/labs/lab_4/filesTxt/FirstTxtFile.txt");
            FileWriter file2 = new FileWriter("src/labs/lab_4/filesTxt/SecondTxtFile.txt");
            BufferedReader reader = new BufferedReader(file1);
            BufferedWriter writer = new BufferedWriter(file2);
            while (reader.ready()) {
                writer.write(reader.readLine() + "\n");
                writer.flush();
            }
            writer.close();
            reader.close();
            System.out.println("Текст записан в новый файл");
        } catch (IOException e) {
            System.err.println("Файл не может быть открыт");
        }

        int age = 1;

        try {
            validateAge(age);
            System.out.println("Возраст корректный");
        } catch (CustomAgeException e) {
            System.err.println(e.getMessage());
        }


    }

    public static void validateAge(int age) throws CustomAgeException {
        if (age < 0 || age > 120) {
            throw new CustomAgeException("Недопустимый возраст");
        }
    }
}

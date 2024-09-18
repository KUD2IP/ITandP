package tasks.task_2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("\ntask 1: ");

        System.out.println("Barack, Obama -> " + duplicateChars("Barack", "Obama"));

        System.out.println("Доп тесты: ");
        System.out.println("Carlos, Carmen -> " + duplicateChars("Carlos", "Carmen"));
        System.out.println("Posadas, Piedras -> " + duplicateChars("Posadas", "Piedras"));


        System.out.println("\ntask 2: ");

        System.out.println("[3, 12, 7, 81, 52] -> " + dividedByThree(new int[]{3, 12, 7, 81, 52}));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 3; i++) {
            int[] arr = new int[rand.nextInt(3,10)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt(1000);
            }
            System.out.println(Arrays.toString(arr) + " -> " + dividedByThree(arr));
        }

        System.out.println("\ntask 3: ");



    }


    public static String duplicateChars(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        Set<String> set = new HashSet<>(List.of(str1.split("")));
        for (String c : str2.split("")) {
            set.remove(String.valueOf(c));
        }

        StringBuilder sb = new StringBuilder();

        for (String c : set) {
            sb.append(c);
        }
        return sb.toString();
    }


    public static int dividedByThree(int[] arr) {
        int count = 0;
        for (int num : arr){
            if (num % 3 == 0 && num % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    public static String getInitials(String name) {
        String[] arr = name.split(" ");
        StringBuilder sb = new StringBuilder();
        return null;
    }

}

//getInitials("simonov sergei evgenievich") ➞ "S.E.Simonov"
//getInitials("kozhevnikova tatiana vitalevna") ➞ "T.V. Kozhevnikova "

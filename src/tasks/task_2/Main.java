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
        System.out.println("simonov sergei evgenievich -> " + getInitials("simonov sergei evgenievich"));
        System.out.println( "kozhevnikova tatiana vitalevna -> " + getInitials("kozhevnikova tatiana vitalevna"));

        System.out.println("Доп тесты: ");
        System.out.println("storozhev ivan andreevich -> " + getInitials("storozhev ivan andreevich"));
        System.out.println("kuznetsov alexander alexandrovich -> " + getInitials("kuznetsov alexander alexandrovich"));

        System.out.println("\ntask 4: ");

        System.out.println("[3.5, 7.0, 1.5, 9.0, 5.5] -> " + Arrays.toString(normalizator(new double[]{3.5, 7.0, 1.5, 9.0, 5.5})));
        System.out.println("[10.0, 10.0, 10.0, 10.0] -> " + Arrays.toString(normalizator(new double[]{10.0, 10.0, 10.0, 10.0})));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 3; i++) {
            double[] arr = new double[rand.nextInt(3,10)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextDouble(1, 10);
                arr[j] = Math.round(arr[j] * 100.0) / 100.0;
            }
            System.out.println(Arrays.toString(arr) + " -> " + Arrays.toString(normalizator(arr)));
        }

        System.out.println("\ntask 5: ");
        System.out.println(Arrays.toString(compressedNums(new double[]{1.6, 0, 212.3, 34.8, 0, 27.5})));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 3; i++) {
            double[] arr = new double[rand.nextInt(3,10)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextDouble(0, 400);
                arr[j] = Math.round(arr[j] * 100.0) / 100.0;
            }
            System.out.println(Arrays.toString(arr) + " -> " + Arrays.toString(compressedNums(arr)));
        }

        System.out.println("\ntask 6: ");

        System.out.println("helloWorld -> " + camelToSnake("helloWorld"));

        System.out.println("Доп тесты: ");
        System.out.println("javaScript -> " + camelToSnake("javaScript"));
        System.out.println("partyTime -> " + camelToSnake("partyTime"));
        System.out.println("losAngeles -> " + camelToSnake("losAngeles"));

        System.out.println("\ntask 7: ");

        System.out.println("[3, 5, 8, 1, 2, 4] -> " + secondBiggest(new int[]{3, 5, 8, 1, 2, 4}));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 3; i++) {
            int[] arr = new int[rand.nextInt(3,10)];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = rand.nextInt(1000);
            }
            System.out.println(Arrays.toString(arr) + " -> " + secondBiggest(arr));
        }

        System.out.println("\ntask 8: ");

        System.out.println("baobab, 'b' -> " + localReverse("baobab", 'b'));
        System.out.println("Hello, I’m under the water, please help me, ‘e’ -> " + localReverse("Hello, I’m under the water, please help me, ‘e’ ", 'e'));

        System.out.println("Доп тесты: ");
        System.out.println();

        System.out.println("\ntask 9: ");
        System.out.println("(8, 1, 8) -> " + equal(8, 1, 8));
        System.out.println("(5, 5, 5) -> " + equal(5, 5, 5));
        System.out.println("(4, 9, 6) -> " + equal(4, 9, 6));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int a = rand.nextInt(10);
            int b = rand.nextInt(10);
            int c = rand.nextInt(10);
            System.out.println("(" + a + ", " + b + ", " + c + ") -> " + equal(a, b, c));
        }

        System.out.println("\ntask 10: ");
        System.out.println("LISTEN, silent -> " + isAnagram("listen", "silent"));
        System.out.println("Eleven plus two?, Twelve plus one -> " + isAnagram("Eleven plus two?", "Twelve plus one!"));
        System.out.println("hello, world -> " + isAnagram("hello", "world"));

        System.out.println("Доп тесты: ");
        System.out.println();
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
        String a = arr[1];
        arr[1] = arr[2];
        arr[2] = a;
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(i == 0) {
                for (int j = 0; j < arr[i].length(); j++) {
                    if(j == 0) {
                        sb.append(arr[i].toUpperCase().charAt(j));
                        continue;
                    }
                    sb.append(arr[i].charAt(j));
                }
                break;
            }
            sb.append(arr[i].toUpperCase().charAt(0)).append(".");
        }
        return sb.toString();
    }

    public static double[] normalizator(double[] arr) {
        double min = Arrays.stream(arr).min().getAsDouble();
        double max = Arrays.stream(arr).max().getAsDouble();
        for (int i = 0; i < arr.length; i++) {
            if (min == max) {
                arr[i] = 0;
                continue;
            }
            arr[i] = (arr[i] - min) / (max - min);
            arr[i] = Math.round(arr[i] * 10000.0) / 10000.0;
        }
        return arr;
    }

    public static int[] compressedNums(double[] arr) {
        int countZeros = 0;

        for (double v : arr) {
            if ((int) v == 0) {
                countZeros++;
            }
        }
        int[] intArr = new int[arr.length - countZeros];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                intArr[j] = (int) arr[i];
                j++;
            }
        }

        Arrays.sort(intArr);

        return intArr;
    }

    public static String camelToSnake(String str) {
        String[] arr = str.split("(?=[A-Z])");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i].toLowerCase());
                break;
            }
            sb.append(arr[i].toLowerCase()).append("_");
        }

        return sb.toString();
    }

    public static int secondBiggest(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static String localReverse(String str, char c) {
        return null;
    }

    public static int equal(int a, int b, int c) {
        if (a == b && b == c) {
            return 3;
        } else if (a == b || b == c || a == c) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean isAnagram(String str1, String str2) {
        return false;
    }
}


package tasks.task_3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("task 1:");

        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(isStrangePair("sparkling", "groups"));
        System.out.println(isStrangePair("bush", "hubris"));
        System.out.println(isStrangePair("", ""));


        System.out.println("\ntask 2:");

        Map<String, Integer> map = new HashMap<>();
        map.put("Laptop", 124200);
        map.put("Phone", 51450);
        map.put("Headphones", 13800);
        System.out.println(sale(map, 25));


        System.out.println("\ntask 3:");

        System.out.println(sucsessShoot(2, 2, 5, 2, 2));
        System.out.println(sucsessShoot(-2, -3, 4, 5, -6));


        System.out.println("\ntask 4:");

        System.out.println(parityAnalysis(243));
        System.out.println(parityAnalysis(12));
        System.out.println(parityAnalysis(3));


        System.out.println("\ntask 5:");

        System.out.println(rps("rock", "paper"));
        System.out.println(rps("paper", "rock") );
        System.out.println(rps("paper", "scissors"));
        System.out.println(rps("scissors", "scissors"));
        System.out.println(rps("scissors", "paper"));


        System.out.println("\ntask 6:");

        System.out.println(bugger(39));
        System.out.println(bugger(999));
        System.out.println(bugger(4));


        System.out.println("\ntask 7:");

        System.out.println(mostExpensive(new Object[][]{{"Скакалка", 550, 8}, {"Шлем", 3750, 4}, {"Мяч", 2900, 10}}));


        System.out.println("\ntask 8:");

        System.out.println(longestUnique("abcba"));
        System.out.println(longestUnique("bbb"));


        System.out.println("\ntask 9:");

        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        System.out.println(isPrefix("retrospect", "sub-"));
        System.out.println(isSuffix("vocation", "-logy"));


        System.out.println("\ntask 10:");

        System.out.println(doesBrickFit(1, 1, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 1, 1, 1));
        System.out.println(doesBrickFit(1, 2, 2, 1, 1));
    }


    public static boolean isStrangePair(String a, String b) {
        if(a.equals(b)) return true;
        else if (a.isEmpty() || b.isEmpty()) return true;
        return a.charAt(0) == b.charAt(b.length() - 1) && b.charAt(0) == a.charAt(a.length() - 1);
    }

    public static Map<String, Integer> sale(Map<String, Integer> map, int sale) {
        map.replaceAll((k, v) -> v - v * sale / 100);
        return map;
    }

    public static boolean sucsessShoot(int x, int y, int r, int a, int b) {

        return Math.sqrt(Math.pow((a - x), 2) + Math.pow((b - y), 2)) <= r;
    }

    public static boolean parityAnalysis(int n) {
        int sum = 0;
        int temp = n;
        while (temp > 0){
            sum += temp % 10;
            temp /= 10;
        }
        return sum % 2 == n % 2;
    }

    public static String rps(String a, String b) {
        if(a.equals(b)) return "Tie";
        Map<String, String> map = new HashMap<>(
            Map.of("rock", "scissors", "paper", "rock", "scissors", "paper")
        );
        if(map.get(a).equals(b)) return "Player 1 won";

        return "Player 2 won";
    }

    public static int bugger(int n) {
        int i = n;
        int count = 0;
        while (i > 10) {
            int temp = i;
            i = 1;
            while (temp > 0) {
                i *= temp % 10;
                temp /= 10;
            }
            count++;
        }
        return count;
    }

    public static String mostExpensive(Object[][] arr) {
        int max = 0;
        String name = "";
        for (Object[] objects : arr) {
            int n = 1;
            for (Object s : objects) {
                if (s instanceof String) {
                    name = (String) s;
                }
                if(s instanceof Integer) {
                    n *= (int) s;
                }
            }
            max = Math.max(max, n);
        }
        return "Наиб. общ. стоимость у предмета " + name + " - " + max;
    }

    public static String longestUnique(String str) {

        StringBuilder sb = new StringBuilder();
        int size = 0;
        int len = 0;
        int max = 0;

        Map<Integer, String> map = new HashMap<>();

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
            size++;

            if(set.size() == size){
                sb.append(str.charAt(i));
                len++;
            }else{
                max = Math.max(max, len);
                map.put(len, sb.toString());
                sb = new StringBuilder();
                set.clear();
                size = 0;
                len = 0;
            }
        }
        return map.get(max);
    }

    public static boolean isPrefix(String word, String prefix) {
        prefix = prefix.replace("-", "");
        return word.startsWith(prefix);
    }

    public static boolean isSuffix(String word, String suffix) {
        suffix = suffix.replace("-", "");
        return word.endsWith(suffix);
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (w >= a && h >= b) || (w >= b && h >= a) || (w >= a && h >= c) || (w >= c && h >= a) || (w >= b && h >= c) || (w >= c && h >= b);
    }

}

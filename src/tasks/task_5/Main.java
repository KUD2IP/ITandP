package tasks.task_5;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println("task 1: ");

        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));

        System.out.println("\ntask 2: ");

        System.out.println(memeSum(26, 39));
        System.out.println(memeSum(122, 81));
        System.out.println(memeSum(1222, 30277));

        System.out.println("\ntask 3: ");

        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));

        System.out.println("\ntask 4: ");

        System.out.println(totalPoints(new String[]{"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));

        System.out.println("\ntask 5: ");

        System.out.println(longestRun(new int[]{1, 2, 3, 5, 6, 7, 8, 9}));
        System.out.println(longestRun(new int[]{1, 2, 3, 10, 11, 15}));
        System.out.println(longestRun(new int[]{5, 4, 2, 1}));
        System.out.println(longestRun(new int[]{3, 5, 7, 10, 15}));

        System.out.println("\ntask 6: ");

        System.out.println(takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[]{"10%"}));
        System.out.println(takeDownAverage(new String[]{"53%", "79%"}));

        System.out.println("\ntask 7: ");

        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canMove("Queen", "C4", "D6"));

        System.out.println("\ntask 8: ");

        System.out.println(maxPossible(9328, 456));
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println(maxPossible(8732, 91255));

        System.out.println("\ntask 9: ");

        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing"));

        System.out.println("\ntask 10: ");

        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(321));
        System.out.println(isNew(123));


    }

    //№1
    public static boolean sameLetterPattern(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        return getPattern(str1).equals(getPattern(str2));
    }

    private static String getPattern(String s) {
        HashMap<Character, Integer> letterIndex = new HashMap<>();
        StringBuilder pattern = new StringBuilder();
        int index = 0;
        for (char letter : s.toCharArray()) {
            if (!letterIndex.containsKey(letter)) {
                letterIndex.put(letter, index++);
            }
            pattern.append(letterIndex.get(letter));
        }
        return pattern.toString();
    }

    //№2
    public static int memeSum(int a, int b) {
        StringBuilder sum = new StringBuilder();
        while (a > 0 || b > 0) {
            sum.insert(0, (a % 10 + b % 10));
            a /= 10;
            b /= 10;
        }
        return Integer.parseInt(sum.toString());
    }

    //№3
    public static int digitsCount(long n) {
        if (n == 0) {
            return 1;
        }

        int sum = 0;
        while (n > 0) {
            sum++;
            n /= 10;
        }
        return sum;
    }

    //№4
    public static int totalPoints(String[] guessedWords, String unscrambledWord) {
        int totalScore = 0;
        for (String word : guessedWords) {
            if (isValidWord(word, unscrambledWord)) {
                int wordLength = word.length();
                if (wordLength == 3) {
                    totalScore += 1;
                } else if (wordLength == 4) {
                    totalScore += 2;
                } else if (wordLength == 5) {
                    totalScore += 3;
                } else if (wordLength == 6) {
                    totalScore += 4 + 50;
                }
            }
        }
        return totalScore;
    }

    private static boolean isValidWord(String word, String unscrambledWord) {
        Map<Character, Integer> letterCount = new HashMap<>();
        for (char letter : unscrambledWord.toCharArray()) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
        }
        for (char letter : word.toCharArray()) {
            if (!letterCount.containsKey(letter) || letterCount.get(letter) == 0) {
                return false;
            }
            letterCount.put(letter, letterCount.get(letter) - 1);
        }
        return true;
    }

    //№5
    public static int longestRun(int[] arr) {
        int max = 0;
        int current = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1 || arr[i] == arr[i + 1] + 1) {
                current++;
            }
            if (arr[i] != arr[i + 1] - 1 && arr[i] != arr[i + 1] + 1) {
                current = 1;
            }
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    //№6
    public static String takeDownAverage(String[] classScores) {
        int totalScore = 0;
        int numberOfScores = classScores.length;

        for (String score : classScores) {
            totalScore += Integer.parseInt(score.replace("%", ""));
        }

        double currentAverage = totalScore / (double) numberOfScores;
        double newAverage = currentAverage - 5;
        double requiredScore = (newAverage * (numberOfScores + 1)) - totalScore;
        int roundedScore = (int) Math.round(requiredScore);

        return roundedScore + "%";
    }

    //№7
    public static boolean canMove(String piece, String start, String end) {
        int startX = start.charAt(0) - 'A';
        int startY = start.charAt(1) - '1';
        int endX = end.charAt(0) - 'A';
        int endY = end.charAt(1) - '1';

        return switch (piece.toLowerCase()) {
            case "rook" -> startX == endX || startY == endY;
            case "bishop" -> Math.abs(startX - endX) == Math.abs(startY - endY);
            case "queen" -> (startX == endX || startY == endY) || (Math.abs(startX - endX) == Math.abs(startY - endY));
            case "king" -> Math.abs(startX - endX) <= 1 && Math.abs(startY - endY) <= 1;
            case "knight" ->
                    (Math.abs(startX - endX) == 2 && Math.abs(startY - endY) == 1) || (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 2);
            case "pawn" ->
                // Assuming we only consider forward moves for simplicity
                    (startX == endX) && ((endY - startY == 1) || (startY == 1 && endY - startY == 2));
            default -> false;
        };
    }

    //№8
    public static int maxPossible(int num1, int num2) {
        List<Integer> num2Digits = Arrays.stream(Integer.toString(num2).split(""))
                .map(Integer::parseInt)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        char[] num1Digits = Integer.toString(num1).toCharArray();

        int index = 0;
        for (int i = 0; i < num1Digits.length && index < num2Digits.size(); i++) {
            int currentDigit = num1Digits[i] - '0';
            if (num2Digits.get(index) > currentDigit) {
                num1Digits[i] = Character.forDigit(num2Digits.get(index), 10);
                index++;
            }
        }
        return Integer.parseInt(new String(num1Digits));
    }

    //№9
    public static String timeDifference(String cityA, String timestamp, String cityB) {
        Map<String, String> cityTimeZones = new HashMap<>();
        cityTimeZones.put("Los Angeles", "GMT-08:00");
        cityTimeZones.put("New York", "GMT-05:00");
        cityTimeZones.put("Caracas", "GMT-04:30");
        cityTimeZones.put("Buenos Aires", "GMT-03:00");
        cityTimeZones.put("London", "GMT");
        cityTimeZones.put("Rome", "GMT+01:00");
        cityTimeZones.put("Moscow", "GMT+03:00");
        cityTimeZones.put("Tehran", "GMT+03:30");
        cityTimeZones.put("New Delhi", "GMT+05:30");
        cityTimeZones.put("Beijing", "GMT+08:00");
        cityTimeZones.put("Canberra", "GMT+10:00");

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime localDateTime = LocalDateTime.parse(timestamp, inputFormatter);

        ZoneId zoneIdA = ZoneId.of(cityTimeZones.get(cityA));
        ZonedDateTime zonedDateTimeA = localDateTime.atZone(zoneIdA);

        ZoneId zoneIdB = ZoneId.of(cityTimeZones.get(cityB));
        ZonedDateTime zonedDateTimeB = zonedDateTimeA.withZoneSameInstant(zoneIdB);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d HH:mm");
        return zonedDateTimeB.format(outputFormatter);
    }

    //№10
    public static boolean isNew(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
        StringBuilder minNumber = new StringBuilder();
        for (char digit : digits) {
            minNumber.append(digit);
        }
        return Integer.parseInt(minNumber.toString()) == num;
    }
}


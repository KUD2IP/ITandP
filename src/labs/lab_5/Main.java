package labs.lab_5;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {

        //#1
        String text = "The price of the product is $19.99";
        numberFinder(text);

        //#2
        String password = "1Password123";
        String password2 = "";
        passwordValidator(password);
        passwordValidator(password2);

        //#3
        String str = "This iS a Test StrIng with a CapitAl Letter.";
        findCapitalLetters(str);

        //#4
        String ip = "192..168.1.1";
        IpValidator(ip);

        //#5
        String string = "Apple banana apricot avocado.";
        char letter = 'a';
        findWords(string, letter);

    }

    public static void numberFinder(String text) {
        Pattern pattern = Pattern.compile("\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void passwordValidator(String password) {
        try {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Пароль не должен быть пустым");
            }
            Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{8,16}$");
            Matcher matcher = pattern.matcher(password);
            if (matcher.matches()) {
                System.out.println("Пароль корректен");
            } else {
                System.out.println("Пароль некорректен");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    public static void findCapitalLetters(String text) {
        try {
            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Текст не должен быть пустым.");
            }
            Pattern pattern = Pattern.compile("(?<=[a-z])([A-Z])");
            Matcher matcher = pattern.matcher(text);
            String result = matcher.replaceAll("!$1!");
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    public static void IpValidator(String ip) {
        try {
            if (ip == null || ip.isEmpty()) {
                throw new IllegalArgumentException("IP-адрес не должен быть пустым.");
            }
            Pattern pattern = Pattern.compile(
                    "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
                            "\\.((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)" +
                            "{2}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
            Matcher matcher = pattern.matcher(ip);
            if (matcher.matches()) {
                System.out.println("IP-адрес корректен.");
            } else {
                System.out.println("IP-адрес некорректен.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }

    public static void findWords(String text, char letter) {
        try {
            if (text == null || text.isEmpty()) {
                throw new IllegalArgumentException("Текст не должен быть пустым.");
            }
            if (letter < 'a' || letter > 'z') {
                throw new IllegalArgumentException("Должна быть строчная латинская буква.");
            }
            Pattern pattern = Pattern.compile("\\b" + letter + "\\w*", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println(matcher.group());
            }

        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}

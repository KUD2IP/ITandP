package labs.lab_1;

public class Palindrome {
    public static void main(String[] args) {
        for (String s : args) {
            System.out.println(s + " -> " + isPalindrome(s));
        }
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }


    public static boolean isPalindrome(String s) {
        return s.equalsIgnoreCase(reverse(s));
    }
}

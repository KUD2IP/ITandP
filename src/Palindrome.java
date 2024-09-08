public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("dqd alla dqd"));
    }

    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }


    public static boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }
}

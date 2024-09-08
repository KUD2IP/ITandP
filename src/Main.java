import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();

        System.out.println("task 1: ");

        System.out.println("5г. -> " + convert(5) + "л.");
        System.out.println("3г. -> " + convert(3) + "л.");
        System.out.println("8г. -> " + convert(8) + "л.");

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int lit = rand.nextInt(50);
            System.out.println(lit + "г. -> " + convert(lit) + "л.");
        }

        System.out.println("\ntask 2: ");

        System.out.println("15 мин. " + "1 инт. -> " +  fitCalc(15, 1) + " ккал.");
        System.out.println("24 мин. " + "2 инт. -> " +  fitCalc(24, 2) + " ккал.");
        System.out.println("41 мин. " + "3 инт. -> " +  fitCalc(41, 3) + " ккал.");

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int minutes = rand.nextInt(1, 240);
            int intensity = rand.nextInt(1,4);
            System.out.println(minutes + " мин. " + intensity + " инт. -> " +  fitCalc(minutes, intensity) + " ккал.");
        }

        System.out.println("\ntask 3: ");

        System.out.println("3 кор. " + "4 меш. " + "2 боч. -> " + containers(3, 4, 2) + " кол.");
        System.out.println("5 кор. " + "0 меш. " + "2 боч. -> " + containers(5, 0, 2) + " кол.");
        System.out.println("4 кор. " + "1 меш. " + "4 боч. -> " + containers(4, 1, 4) + " кол.");

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int box = rand.nextInt(20);
            int bags = rand.nextInt(20);
            int barrels = rand.nextInt(20);

            System.out.println( box + " кор. " + bags + " меш. " + barrels + " боч. -> " + containers(box, bags, barrels) + " кол.");
        }

        System.out.println("\ntask 4: ");

        System.out.println("5, 5, 5 -> " + triangleType(5, 5, 5));
        System.out.println("5, 4, 5 -> " + triangleType(5, 4, 5));
        System.out.println("3, 4, 5 -> " + triangleType(3, 4, 5));
        System.out.println("5, 1, 1 -> " + triangleType(5, 1, 1));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int x = rand.nextInt(1, 20);
            int y = rand.nextInt(1, 20);
            int z = rand.nextInt(1, 20);
            System.out.println(x + ", " + y + ", " + z + " -> " + triangleType(x, y, z));
        }

        System.out.println("\ntask 5: ");

        System.out.println("8, 4 -> " + ternaryEvaluation(8, 4));
        System.out.println("1, 11 -> " + ternaryEvaluation(1, 11));
        System.out.println("5, 9 -> " + ternaryEvaluation(5, 9));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int a = rand.nextInt(-20, 20);
            int b = rand.nextInt(-20, 20);
            System.out.println(a + ", " + b + " -> " + ternaryEvaluation(a, b));
        }

        System.out.println("\ntask 6: ");

        System.out.println("22 м., 1.4 м., 2 м. -> " + howManyItems(22, 1.4, 2) + " шт.");
        System.out.println("45 м., 1.8 м., 1.9 м. -> " + howManyItems(45, 1.8, 1.9) + " шт.");
        System.out.println("100 м., 2 м., 2 м. -> " + howManyItems(100, 2, 2) + " шт.");

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            double t = rand.nextInt(20, 100);
            double w = (double) Math.round(rand.nextDouble(1, 5) * 10) / 10;
            double h = (double) Math.round(rand.nextDouble(1, 5) * 10) / 10;
            System.out.println(t + " м., " + w + " м., " + h + " м. -> " + howManyItems(t, w, h) + " шт.");
        }


        System.out.println("\ntask 7: ");

        System.out.println("3 -> " + factorial(3));
        System.out.println("5 -> " + factorial(5));
        System.out.println("7 -> " + factorial(7));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int n = rand.nextInt(1, 15);
            System.out.println(n + " -> " + factorial(n));
        }


        System.out.println("\ntask 8: ");

        System.out.println("48, 18 -> " + gcd(48, 18));
        System.out.println("52, 8 -> " + gcd(52, 8));
        System.out.println("259, 28 -> " + gcd(259, 28));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int a = rand.nextInt(1, 100);
            int b = rand.nextInt(1, 100);
            System.out.println(a + ", " + b + " -> " + gcd(a, b));
        }


        System.out.println("\ntask 9: ");

        System.out.println("70, 1500 -> " + ticketSaler(70, 1500));
        System.out.println("24, 950 -> " + ticketSaler(24, 950));
        System.out.println("53, 1250 -> " + ticketSaler(53, 1250));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int a = rand.nextInt(1, 100);
            int b = rand.nextInt(500, 2000);
            System.out.println(a + ", " + b + " -> " + ticketSaler(a, b));
        }


        System.out.println("\ntask 10: ");

        System.out.println("5, 2, -> " + tables(5, 2));
        System.out.println("31, 20, -> " + tables(31, 20));
        System.out.println("123, 58, -> " + tables(123, 58));

        System.out.println("Доп тесты: ");
        for (int i = 0; i < 2; i++) {
            int a = rand.nextInt(1, 100);
            int b = rand.nextInt(1, 100);
            System.out.println(a + ", " + b + " -> " + tables(a, b));
        }
    }

    public static double convert(double a){

        return a * 3.78541;
    }

    public static int fitCalc(int minutes, int intensity) {

        return minutes * intensity;
    }

    public static int containers(int box, int bags, int barrels) {

        return box * 20 + bags * 50 + barrels * 100;
    }

    public static String triangleType(int x, int y, int z) {

        if(x + y <= z || x + z <= y || y + z <= x) {
            return "not a triangle";
        } else if(x == y && y == z ) {
            return "equilateral";
        } else if (x == y || x == z || y == z) {
            return "isosceles";
        }else {
            return "different-sided";
        }
    }

    public static int ternaryEvaluation(int a, int b){

        return a > b ? a : b;
    }

    public static int howManyItems(double t, double w, double h){

        return (int) (t / (w * h * 2));
    }

    public static int factorial(int n) {

        if (n == 0) return 1;

        return n * factorial(n - 1);
    }

    public static int gcd(int a, int b) {

        while (a != b){

            if (a > b){
                a = a - b;
            }else {
                b = b - a;
            }
        }

        return a;
    }

    public static int ticketSaler(int a, int b) {

        return (int) (a * b * 0.72);
    }

    public static int tables(int a, int b) {

        if (a % 2 != 0) a++;

        a = a / 2;

        if (a > b) return a - b;

        return 0;
    }
}
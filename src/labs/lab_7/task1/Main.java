package labs.lab_7.task1;

public class Main {
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int middle = array.length / 2;
        SumArrayThread sumArrayThread = new SumArrayThread(array, 0, middle);
        SumArrayThread sumArrayThread1 = new SumArrayThread(array, middle, array.length);
        sumArrayThread.start();
        sumArrayThread1.start();
        try {
            sumArrayThread.join();
            sumArrayThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Sum = " + (sumArrayThread.getSum() + sumArrayThread1.getSum()));
    }
}

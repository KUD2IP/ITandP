package labs.lab_7.task2;

import static java.lang.Integer.MIN_VALUE;

public class Main {
    public static void main(String[] args) {

        int[][] matrix = {
                {11, 23, 34},
                {463, 10, 61},
                {73, 82, 98}
        };

        MaxFinderThread[] maxFinderThread = new MaxFinderThread[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            maxFinderThread[i] = new MaxFinderThread(matrix[i]);
            maxFinderThread[i].start();
        }

        int max = MIN_VALUE;

        try {
            for (MaxFinderThread thread : maxFinderThread) {
                thread.join();
                if (thread.getMax() > max) {
                    max = thread.getMax();
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Max = " + max);

    }
}

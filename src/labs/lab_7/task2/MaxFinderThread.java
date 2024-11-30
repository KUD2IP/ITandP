package labs.lab_7.task2;

import lombok.Getter;
import lombok.Setter;

import static java.lang.Integer.MIN_VALUE;

@Getter
@Setter
public class MaxFinderThread extends Thread {
    private int[] row;
    private int max;

    public MaxFinderThread(int[] row) {
        this.row = row;
        this.max = MIN_VALUE;
    }

    @Override
    public void run() {
        for (int i : row) {
            if (i > max) {
                max = i;
            }
        }
    }
}

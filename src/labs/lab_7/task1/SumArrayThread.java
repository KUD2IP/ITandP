package labs.lab_7.task1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SumArrayThread extends Thread{

    private int[] array;
    private int start;
    private int end;
    private int sum;

    public SumArrayThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
    }
}

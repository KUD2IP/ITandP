package labs.lab_6.task2;

import java.util.Arrays;

public class Stack<T> {
    private T[] data;
    private int size;
    public Stack() {
        data = (T[]) new Object[5];
        size = 0;
    }
    public void push(T element) {
        data[size++] = element;

        if(size >= data.length * 0.75) {
            resize();
        }
    }
    public T pop() {
        if (isEmpty()){
            return null;
        }
        T element = data[size - 1];
        data[size - 1] = null;
        size--;
        return element;
    }
    public T peek() {
        if (isEmpty()){
            return null;
        }
        return data[size - 1];
    }

    private void resize() {
        T[] oldData = data;
        data = (T[]) new Object[oldData.length * 2];
        for (int i = 0; i < oldData.length; i++) {
            data[i] = oldData[i];
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] getData() {
        return data;
    }

    public void setData(T[] data) {
        this.data = data;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (T datum : data) {
            if (datum != null) {
                sb.append(datum).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
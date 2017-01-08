package Lection3.Task1;

public class CoolArray<T> {

    private final static int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size;

    public CoolArray() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public CoolArray(int capacity) {
        array = (T[]) new Object[capacity];
    }

    public void add(T object) {
        if (size + 1 >= array.length) {
            T[] temp = (T[]) new Object[array.length * 3 / 2 + 1];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
        array[size++] = object;
    }

    public T get(int index) throws IllegalArgumentException {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index value");
        }
        return array[index];
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
        size = array.length;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T object : array) {
            if (object != null){
            sb.append(object).append(" ; ");}
        }
        return sb.toString();
    }
}

package Lection7.Task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversion<E> {

    private List<E> list = new ArrayList<>();

    public Conversion () {
    }

    public Conversion(E[] array) {
        list.addAll(Arrays.asList(array));
    }

    public void showList() {
        for (Object ls : list) {
            System.out.print(ls);
        }
        System.out.println();
    }

    public void add(E element) {
        list.add(element);
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        list.remove(index);
    }

    public void remove(int from, int to) throws IndexOutOfBoundsException{
        checkIndex(from);
        checkIndex(to);
        list.subList(from, to).clear();
    }

    public void clear() {
        list.clear();
    }

    public List getList() {
        return list;
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + list.size());
        }
    }
}

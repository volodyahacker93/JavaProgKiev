package Lection7.Task5;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private E[] elementData;
    private int size;

    public MyArrayList() {
        elementData = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        elementData = (E[]) new Object[capacity];
    }

    @Override
    public void add(E element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index);
        ensureCapacity(size + 1);
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public void addAll(E[] array) {
        for(E ar : array) {
            add(ar);
        }
    }

    @Override
    public void addAll(int index, E[] array) throws IndexOutOfBoundsException{
        checkIndex(index);
        int i = index;
        for (E ar : array) {
            add(i++, ar);
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        return elementData[index];
    }

    @Override
    public void set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index);
        elementData[index] = element;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException{
        checkIndex(index);
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
    }

    @Override
    public void remove(E element) {
        int index = indexOf(element);
        remove(index);
    }

    @Override
    public void clear() {
        setCapacity(DEFAULT_CAPACITY);
        size = 0;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (element.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(E element) {
        return (indexOf(element) != -1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyList subList(int from, int to) throws IndexOutOfBoundsException{
        checkIndex(from);
        checkIndex(to);
        int subSize = to - from;
        E[] list = (E[]) new Object[subSize];
        System.arraycopy(elementData, from, list, 0, subSize);
        MyArrayList<E> newList = new MyArrayList<>(subSize);
        newList.addAll(elementData);

        return newList;
    }

    public void ensureCapacity(int minCapacity) throws IndexOutOfBoundsException {
        if(minCapacity > Integer.MAX_VALUE) {
            throw new IndexOutOfBoundsException("Capacity > MAX_VALUE: " + minCapacity + " > " + Integer.MAX_VALUE);
        }

        if (minCapacity > elementData.length) {
            E[] oldData = (E[]) new Object[size];
            System.arraycopy(elementData, 0, oldData, 0, size);
            int newCapacity = size * 3 / 2 + 1;
            elementData = (E[]) new Object[newCapacity];
            System.arraycopy(oldData, 0, elementData, 0, size);
        }
    }

    public void setCapacity(int capacity) {
        elementData = (E[]) new Object[capacity];
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if(this.getClass() != object.getClass()) {
            return false;
        }

        MyArrayList other = (MyArrayList) object;
        if(this.size != other.size) {
            return false;
        }

        for(int i = 0; i < size; i++) {
            if(!this.elementData[i].equals(other.elementData[i])) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        return (Arrays.hashCode(elementData) + size);
    }
}

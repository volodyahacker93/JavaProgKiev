package Lection7.Task5;

public class MyLinkedList<E> implements MyList<E> {

    private static class Entry<E> {

        E element;
        Entry<E> next;
        Entry<E> prev;

        Entry(E element, Entry<E> next, Entry<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Entry<E> header;
    private int size;

    public MyLinkedList() {
        header = new Entry<>(null, null, null);
        header.next = header;
        header.prev = header;
    }

    @Override
    public void add(E element){
        Entry<E> newEntry = new Entry<>(element, header, header.prev);
        newEntry.prev.next = newEntry;
        newEntry.next.prev = newEntry;
        size++;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index);
        Entry<E> entry = entry(index);
        Entry<E> newEntry = new Entry<>(element, entry, entry.prev);
        newEntry.prev.next = newEntry;
        newEntry.next.prev = newEntry;
        size++;
    }

    private Entry<E> entry(int index) throws IndexOutOfBoundsException{
        checkIndex(index);

        Entry<E> entry = header;

        if(index < (size >> 1)) {
            for(int i = 0; i <= index; i++) {
                entry = entry.next;
            }
        } else {
            for (int i = size; i > index; i--) {
                entry = entry.prev;
            }
        }

        return entry;
    }

    @Override
    public void addAll(E[] array) {
        for(E ar : array) {
            add(ar);
        }
    }

    @Override
    public void addAll(int index, E[] array) throws IndexOutOfBoundsException {
        checkIndex(index);
        int i = index;
        for(E ar : array) {
            add(i++, ar);
        }
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return entry(index).element;
    }

    @Override
    public void set(int index, E element) throws IndexOutOfBoundsException{
        checkIndex(index);
        entry(index).element = element;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index);
        Entry<E> element = entry(index);
        element.prev.next = element.next;
        element.next.prev = element.prev;
        element.next = null;
        element.prev = null;
        size--;
    }

    @Override
    public void remove(E element) {
        int index = indexOf(element);
        remove(index);
    }

    @Override
    public void clear() {
        header = new Entry<>(null, header, header);
        size = 0;
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
    public int indexOf(E element) {
        Entry<E> entry = header;
        for(int i = 0; i < size; i++) {
            entry = entry.next;
            if (element.equals(entry.element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E element) {
        Entry<E> entry = entry(size - 1);
        for (int i = size - 1; i > 0; i--) {
            if (element.equals(entry.element)) {
                return i;
            }
            entry = entry.prev;
        }
        return -1;
    }

    @Override
    public MyList subList(int from, int to) throws IndexOutOfBoundsException{
        checkIndex(from);
        checkIndex(to);

        MyLinkedList<E> newList = new MyLinkedList<>();
        Entry<E> entry = entry(from);
        for(int i = from; i < to; i++) {
            newList.add(this.get(i));
            entry = entry.next;
        }

        return newList;
    }

    private void checkIndex(int index) throws IndexOutOfBoundsException {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public boolean equals(Object object) {
        if(object == null) {
            return false;
        }
        if(this == object) {
            return true;
        }
        if(this.getClass() != object.getClass()) {
            return false;
        }
        MyLinkedList other = (MyLinkedList) object;
        if(this.size != other.size) {
            return false;
        }
        Entry<E> entry1 = this.header;
        Entry<E> entry2 = other.header;
        for(int i = 0; i < size; i++) {
            entry1 = entry1.next;
            entry2 = entry2.next;
            if(!entry1.element.equals(entry2.element)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        Entry<E> entry = header;
        for(int i = 0; i < size; i++) {
            entry = entry.next;
            hash += entry.element.hashCode();
        }

        return hash;
    }
}

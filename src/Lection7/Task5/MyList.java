package Lection7.Task5;

public interface MyList <E extends Object> {

    void add(E element);

    void add(int index, E element);

    void addAll(E[] array);

    void addAll(int index, E[] element);

    Object get(int index);

    void set(int index, E element);

    void remove(int index);

    void remove(E element);

    void clear();

    boolean contains(E element);

    int size();

    int indexOf(E element);

    int lastIndexOf(E element);

    MyList subList(int from, int to);

    @Override
    public boolean equals(Object object);

    @Override
    public int hashCode();
}


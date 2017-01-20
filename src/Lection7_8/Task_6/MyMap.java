package Lection7_8.Task_6;

/*
Реализовать методы HashMap: keySet, entrySet, containsValue etc
*/

import java.util.Set;

public interface MyMap<K extends Object, V extends Object>{

    void put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    int size();

    boolean containsValue(V value);

    Set<K> keySet();
}

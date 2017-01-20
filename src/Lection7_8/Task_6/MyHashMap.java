package Lection7_8.Task_6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V>{

    public static class Entry<K, V> {

        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private List[] arr;

    public MyHashMap(int capacity) {
        arr = new LinkedList[capacity];
    }

    public MyHashMap() {
        arr = new LinkedList[DEFAULT_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);

        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % arr.length);

        if(arr[index] == null) {
            arr[index] = new LinkedList<>();
        }

        List<Entry<K, V>> list = (LinkedList<Entry<K, V>>) arr[index];

        for(Entry<K, V> ent : list) {
            if(ent.getKey().equals(entry.getKey())) {
                ent.setValue(entry.getValue());
                return;
            }
        }
        list.add(entry);
    }

    @Override
    public V get(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % arr.length);

        if (arr[index] == null) {
            return null;
        }

        LinkedList<Entry<K, V>> list = (LinkedList<Entry<K,V>>) arr[index];
        for(Entry<K, V> entry : list) {
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public int size() {
        List<Entry<K, V>> list;
        int size = 0;

        for(Object ar : arr) {
            list = (LinkedList<Entry<K,V>>) ar;
            if(list != null) {
                size += list.size();
            }
        }
        return size;
    }

    @Override
    public boolean containsValue(V value) {
        List<Entry<K, V>> list;
        for(List ar : arr) {
            if(ar != null) {
                list = (LinkedList<Entry<K,V>>) ar;
                for(Entry<K, V> entry : list) {
                    if(entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        LinkedList<Entry<K, V>> list;

        for(List ar : arr) {
            if(ar != null) {
                list = (LinkedList<Entry<K,V>>) ar;
                for(Entry<K, V> entry : list) {
                    set.add(entry.getKey());
                }
            }
        }

        return set;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        LinkedList <Entry<K, V>> list;

        for(List ar : arr) {
            if(ar != null) {
                list = (LinkedList<Entry<K,V>>) ar;
                for(Entry<K, V> ls : list) {
                    set.add(ls);
                }
            }
        }
        return set;
    }

    public void setCapacity(int capacity) {
        arr = new LinkedList[capacity];
    }
}

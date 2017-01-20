package Lection7_8.Task_5;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Database<K, V> implements Serializable{

    private static final long serialVersionUID = 1L;
    Map<K, V> map = new HashMap<>();

    public void add(K key, V value) {
        map.put(key, value);
    }

    public void delete(K key) {
        map.remove(key);
    }

    public V get(K key) {
        return map.get(key);
    }

    @Override
    public String toString() {
        if(map.isEmpty()) {
            return "Database is empty!";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<K> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            K index = iterator.next();
            sb.append(map.get(index));
        }
        return sb.toString();
    }

}

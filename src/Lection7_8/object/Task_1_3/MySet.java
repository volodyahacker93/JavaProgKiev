package Lection7_8.object.Task_1_3;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet<E> implements Serializable {

    private static final long serialVersionUID = 1L;
    private Set<E> set =  new HashSet<>();

    public boolean add(E obj) {
        return set.add(obj);
    }

    public void print() {
        int counter = 0;
        Iterator<E> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(++counter + ") " + iterator.next());
        }
    }

    public Set<E> getSet() {
        return set;
    }

    public void setSet(Set<E> set) {
        this.set = set;
    }

    public int size() {
        return set.size();
    }
}

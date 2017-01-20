package Lection7_8.Task_6;

public class Main {

    public static void main(String[] args) {
        MyMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "q");
        map.put(2, "w");
        map.put(3, "e");

        for(int i = 1; i <= 3; i++) {
            System.out.println(map.get(i) + " ");
        }
        System.out.println();
    }
}

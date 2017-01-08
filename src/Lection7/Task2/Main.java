package Lection7.Task2;

public class Main {

    public static void main(String[] args) {

        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        Conversion<Integer> list = new Conversion<>(numbers);
        list.remove(0, 2);
        list.remove(list.getList().size() - 1);
        list.showList();

        list.clear();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(0, 2);
        list.remove(list.getList().size() - 1);
        list.showList();
    }
}

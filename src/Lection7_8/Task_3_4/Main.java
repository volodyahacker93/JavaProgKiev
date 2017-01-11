package Lection7_8.Task_3_4;

/*
3. Решить задачу подсчета повторяющихся элементов в массиве с помощью HashMap.
4. Пользователь вводит набор чисел в виде одной строки (―1, 2, 3, 4, 4, 5‖).
Избавиться от повторяющихся элементов в строке и вывести результат на экран.
*/

import java.util.*;

public class Main {

    static <E> List<E> noDuplicate(E[] array) {
        List<E> list = new ArrayList<>();
        Map<E, E> map = new HashMap<>();
        for (E arr : array) {
            map.put(arr, arr);
        }

        Set<Map.Entry<E, E>> set = map.entrySet();
        for (Map.Entry<E, E> st : set) {
            list.add(st.getKey());
        }
        return list;
    }

    static List<String> noDuplicate(String value) {
        String text = value;
        text = text.replace(" ", "");
        String[] arrayString = text.split(",");

        return Main.<String>noDuplicate(arrayString);
    }

    public static void main(String[] args) {
        Integer[] arrayInt = {0, 1, 9, 2, 8, 3, 7, 4, 6, 5, 5, 6, 4, 7, 3, 8, 2, 9, 1, 0};
        List<Integer> listInt = Main.<Integer>noDuplicate(arrayInt);

        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(listInt.toArray()));
        System.out.println("The number of repetitions = " + (arrayInt.length - listInt.size()));

        System.out.println();

        System.out.println("Enter a set of numbers:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<String> listString = Main.<String>noDuplicate(text);

        System.out.println(text);
        System.out.println(Arrays.toString(listString.toArray()));
    }
}

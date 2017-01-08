package Lection7.Task5;

public class Main {

    public static void main(String[] args) {

        String[] lines = {"q", "W", "e", "R", "t", "Y", "q", "W", "e", "R", "t", "Y"};
        MyList<String> arrayList = new MyArrayList<>();
        arrayList.addAll(lines);
        arrayList.remove("q");
        arrayList.remove(1);

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i) + " ");
        }

        System.out.println();
        MyList<String> linkedList = new MyLinkedList<>();
        linkedList.addAll(lines);

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }

        System.out.println();
        System.out.println(linkedList.indexOf("R"));
        MyList<String> linkedLis2 = linkedList.subList(0, linkedList.size());

        for (int i = 0; i < linkedLis2.size(); i++) {
            System.out.print(linkedLis2.get(i) + " ");
        }

        System.out.println();
        System.out.println(linkedLis2.equals(linkedList));
    }
}
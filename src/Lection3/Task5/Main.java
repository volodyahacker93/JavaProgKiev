package Lection3.Task5;

public class Main {

    public static void main(String[] args) {

        int n = 3;
        System.out.println("Enter data about " + n + " students:");

        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + ")");
            Student.add();
        }

        Student.showList();

        Student.delete();

        Student.showList();
    }
}

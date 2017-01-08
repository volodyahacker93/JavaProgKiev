package Lection2.Task2;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        final StudentList list = new StudentList();
        list.add(new Student("Vova", "Ivanov", new Date(1986, 1, 1)));
        list.add(new Student("Vasya", "Pupkin", new Date(1970, 3, 25)));
        list.add(new Student("Max", "Planck", new Date(1858, 4, 23)));
        list.add(new Student("Albert", "Einstein", new Date(1879, 3, 14)));
        list.add(new Student("Isaak", "Newton", new Date(1642, 12, 25)));
// Поиск по имени, вывод студента на екран.
        int n = list.findName("Max");
        System.out.println((n + 1) + ") " + list.getNameSurname(n) + ": " +
                list.get(n).getBirth());
// Поиск по имени, вывод студента на екран.
        n = list.findSurname("Einstein");
        System.out.println((n + 1) + ") " + list.getNameSurname(n) + ": " +
                list.get(n).getBirth());
// Поиск по дате, вывод студента на екран.
        n = list.findDate(new Date(1642, 12, 25));
        System.out.println((n + 1) + ") " + list.getNameSurname(n) + ": " +
                list.get(n).getBirth());
// Удаление студентов
        System.out.println("\nOld list:");
        list.showAllList();
        list.delete(0); // "Vova"
        list.delete(3); // "Isaak"
        System.out.println("\nNew list:");
        list.showAllList();
    }
}

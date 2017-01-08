package Lection2.Task2;

import java.util.Date;

public class StudentList {

    private Student[] list = new Student[10];
    private int counter;
    public void add(Student s) {
        if (counter == list.length) {
            Student[] list = new Student[this.list.length * 3 / 2 + 1];
            System.arraycopy(this.list, 0, list, 0, this.list.length);
            this.list = list;
        }
        list[counter++] = s;
    }
    public void delete(int n) {
        if (n >= 0 && n < list.length) {
            for (int i = n; i < list.length - 1; i++) {
                list[i] = list[i + 1];
            }
            list[list.length - 1] = null;
            counter--;
        }
    }
    public Student get(int n) {
        return list[n];
    }
    public String getNameSurname(int n) {
        return list[n].getName() + " " + list[n].getSurname();
    }
    public int findName(String name) {
        for (int i = 0; i < counter; i++) {
            if (list[i].getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    public int findSurname(String surname) {
        for (int i = 0; i < counter; i++) {
            if (list[i].getSurname().equalsIgnoreCase(surname)) {
                return i;
            }
        }
        return -1;
    }
    public int findDate(Date birth) {
        for (int i = 0; i < counter; i++) {
            if (list[i].getBirth().equals(birth)) {
                return i;
            }
        }

        return -1;
    }
    public void showAllList() {
        for (int i = 0; i < counter; i++) {
            System.out.println((i + 1) + ") " + list[i].getName() + " " +
                    list[i].getSurname() + ": " + list[i].getBirth());
        }
    }
}
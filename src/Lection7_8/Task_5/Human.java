package Lection7_8.Task_5;

import java.io.Serializable;
import java.util.Scanner;

/*
Написать программу «База данных пользователей» с функциями добавления,
удаления, поиска и вывода информации о пользователе по номеру.
*/
public class Human implements Serializable{

    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String birth;
    private long phone;

    public Human() {
    }

    public Human(String name, String surname, String birth, long phone) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = name.hashCode() + surname.hashCode() + birth.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }
        Human other = (Human) obj;
        return (this.name.equals(other.name))&&(this.surname.equals(other.surname))&&
                (this.birth.equals(other.birth));
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Human human = (Human) super.clone();
        return human;
    }

    @Override
    public String toString() {
        return "Name: " + name + " Surname: " + surname +
                " Birth: " + birth + " Phone number: " + phone + "\n";
    }

    public static Human create(Scanner scanner) {
        Human human = new Human();

        scanner.nextLine();
        System.out.println("Enter name: ");
        human.name = scanner.nextLine();

        System.out.println("Enter surname: ");
        human.surname = scanner.nextLine();

        System.out.println("Enter birth: ");
        human.birth = scanner.nextLine();

        System.out.println("Enter phone: ");
        human.phone = scanner.nextLong();

        return human;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}





package Lection7_8.object.Task_1_3;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MySet<Human> humanList = new MySet();
        File file = new File("c:\\dir1\\List.txt");

        if (!file.exists() || !file.isFile() || file.length() == 0) {
            int number = 10;
            System.out.println("Enter data about " + number + " persons:");
            Scanner scan = new Scanner(System.in);
            for (int i = 0; i < number; i++) {
                Human human = new Human();
                System.out.println((i + 1) + ")");
                System.out.print(" Name - ");
                human.setName(scan.nextLine());
                System.out.print(" Surname - ");
                human.setSurname(scan.nextLine());
                System.out.print(" Birth (dd.MM.yyyy) - ");
                human.setBirth(scan.nextLine());
                System.out.print(" Sex - ");
                human.setSex(scan.nextLine());
                if (!humanList.add(human)) {
                    System.out.println("Information about this person has already been added.\nEnter again:");
                    i--;
                }
            }
            humanList.print();
            Serialization.serialize(humanList, file);
        } else {
            humanList = (MySet) Serialization.deserialize(file);
            humanList.print();
        }
    }
}

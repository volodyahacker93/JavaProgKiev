package Lection3.Task7;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Figure[] list = {
                new Circle(5), new Triangle(21,22,23), new Rectangle(1,5), new Circle(10)
        };
        Arrays.sort(list); // !!!!
        for (Figure h : list)
            System.out.println(h.getArea() + " - Figure:  " + h.getName());
    }
}

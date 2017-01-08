package Lection2.Task8;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figure> archik = new ArrayList<Figure>();

        Figure tr1 = new Triangle(21,22,23);
        archik.add(tr1);
        System.out.println("Figure " + tr1.getName() + " has area: " + tr1.getArea());

        Figure sq1 = new Rectangle(1,5);
        archik.add(sq1);
        System.out.println("Figure " + sq1.getName() + " has area: " + sq1.getArea());

        Figure cir1 = new Circle(5);
        archik.add(cir1);
        System.out.println("Figure " + cir1.getName() + " has area: " + cir1.getArea());
    }
}

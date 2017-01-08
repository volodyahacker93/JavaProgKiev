package Lection1.Task1;

public class Main {
    public static void main(String[] args) {
        System.out.println(Circle.NAME);

        Circle c1 = new Circle();
        Circle c2 = new Circle(7);

        System.out.println("Circle1 radius: " + c1.getRadius());
        System.out.println("Circle2 radius: " + c2.getRadius());

        c2.setRadius(22);

        System.out.println("Circle2 radius: " + c2.getRadius());

        Circle c3 = Circle.combine(c1,c2);
        System.out.println("Circle3 radius: " + c3.getRadius());
        System.out.println("S(c1) = " + c1.square());
        for (int i = 0; i < 10; i++) {
            Circle circle = new Circle();
        }
        System.out.println("i = " + Circle.i);
    }
}

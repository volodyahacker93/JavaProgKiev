package Lection1.Task1;

public class Circle {
    public static final String NAME = "Circle";

    public static int i = 0;

    private int radius;

    public Circle() {
        radius = 5;
        i++;
    }

    public Circle(int radius) {
        this.radius = radius;
        i++;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double square() {
        return Math.PI * Math.pow(radius,2);
    }

    public static Circle combine(Circle c1, Circle c2){
        return new Circle(c1.radius + c2.radius);
    }
}



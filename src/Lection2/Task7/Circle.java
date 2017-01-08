package Lection2.Task7;

public class Circle extends Figure {
    private static final String NAME = "Circle";

    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double getArea(){
        return Math.PI * r * r;
    }

    @Override
    public String getName(){
        return NAME;
    }
}

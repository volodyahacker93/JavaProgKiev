package Lection3.Task7;

public abstract class Figure implements Comparable {

    public abstract double getArea();
    public abstract String getName();

    @Override
    public int compareTo(Object another) {
        Figure h = (Figure) another;
        if (getArea() < h.getArea())
            return -1;
        else if (getArea() == h.getArea())
            return 0;

        return 1;
    }

}

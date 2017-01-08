package Lection2.Task4_6;

import java.util.ArrayList;

public abstract class Developer {

    protected String name;
    protected double basicSalary;
    protected int experience;

    public Developer(String name, double basicSalary, int experience) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public abstract double getSalary();

    public void Showarray (ArrayList<Developer> showlist){
        StringBuilder sb;
        for (Developer d : showlist) {
            sb = new StringBuilder() // !!!
                    .append(d.getName())
                    .append(": ")
                    .append(d.getBasicSalary())
                    .append(" -> ")
                    .append(d.getSalary());

            System.out.println(d.getClass()+ " " + sb.toString());
        }
    }


}

package Lection2.Task4_6;

public class MiddleDeveloper extends Developer {

    public MiddleDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        if (experience > 0) return basicSalary * (1.5) + basicSalary * experience * 0.1;
        else return basicSalary + 0;
    }
}

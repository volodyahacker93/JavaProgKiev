package Lection2.Task4_6;

public class SeniorDeveloper extends Developer {

    public SeniorDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        if (experience > 0) return (basicSalary * 2) + basicSalary * experience * 0.1;
        else return (basicSalary * 2) + 0;
    }
}

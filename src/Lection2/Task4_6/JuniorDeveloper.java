package Lection2.Task4_6;

public class JuniorDeveloper extends Developer {

    public JuniorDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        if (experience > 0) return basicSalary + basicSalary * experience * 0.1;
        else return basicSalary + 0;
    }
}

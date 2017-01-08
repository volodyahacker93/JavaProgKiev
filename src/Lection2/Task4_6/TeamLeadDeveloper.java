package Lection2.Task4_6;

public class TeamLeadDeveloper extends Developer {

    public TeamLeadDeveloper(String name, double basicSalary, int experience) {
        super(name, basicSalary, experience);
    }

    @Override
    public double getSalary() {
        if (experience > 0) return (basicSalary * 4) + basicSalary * experience * 0.1;
        else return (basicSalary * 4) + 0;
    }
}

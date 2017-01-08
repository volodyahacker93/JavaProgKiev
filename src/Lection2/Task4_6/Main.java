package Lection2.Task4_6;

public class Main {
    public static void main(String[] args) {
        double basicSalary = 500;
        Developer[] list = {
                new SeniorDeveloper("Otto", basicSalary, 15),
                new JuniorDeveloper("Mike", basicSalary, 0),
                new SeniorDeveloper("Marti", basicSalary, 18),
                new JuniorDeveloper("Dima", basicSalary, 1),
                new MiddleDeveloper("Artur", basicSalary, 0),
                new TeamLeadDeveloper("Alex", basicSalary, 10),
                new JuniorDeveloper("Vova", basicSalary, 2),
                new SeniorDeveloper("Jack", basicSalary, 5),
                new TeamLeadDeveloper("Robby", basicSalary, 7),
                new MiddleDeveloper("Mark", basicSalary, 0),
                new SeniorDeveloper("Tomas", basicSalary, 10),
                new JuniorDeveloper("Hanry", basicSalary, 0),
                new JuniorDeveloper("Leva", basicSalary, 1)
        };
        DeveloperList developerList = new DeveloperList();
        for (Developer d : list) {
            developerList.add(d);
        }
        developerList.showAllList(); // Выводим всех разработчиков
        developerList.showList("Senior developer", 1500); // Выводим ТОЛЬКО "Senior developer" С зарплатой от 1500
        developerList.showList("Junior developer", 0); // Выводим ВСЕХ "Junior developer"
    }
}
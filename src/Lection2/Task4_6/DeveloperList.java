package Lection2.Task4_6;

public class DeveloperList {
    private Developer[] internList = new Developer[10];
    private int iCoun;
    private Developer[] juniorList = new Developer[10];
    private int jCoun;
    private Developer[] seniorList = new Developer[10];
    private int sCoun;
    private Developer[] teamLeadList = new Developer[10];
    private int tlCoun;
    public void add(Developer d) {
        if (d instanceof MiddleDeveloper) {
            internList = check(internList, iCoun);
            internList[iCoun++] = d;
        } else if (d instanceof JuniorDeveloper) {
            juniorList = check(juniorList, jCoun);
            juniorList[jCoun++] = d;
        } else if (d instanceof SeniorDeveloper) {
            seniorList = check(seniorList, sCoun);
            seniorList[sCoun++] = d;
        } else if (d instanceof TeamLeadDeveloper) {
            teamLeadList = check(teamLeadList, tlCoun);
            teamLeadList[tlCoun++] = d;
        }
    }
    private static Developer[] check(Developer[] list, int counter) {
        if (counter == list.length) {
            Developer[] newList = new Developer[list.length * 3 / 2 + 1];
            System.arraycopy(list, 0, newList, 0, list.length);
            return newList;
        } else {
            return list;
        }
    }
    public void showAllList() {
        System.out.println("------------------------\n"
                + "All developers:");
        showList(internList, iCoun, 0);
        showList(juniorList, jCoun, 0);
        showList(seniorList, sCoun, 0);
        showList(teamLeadList, tlCoun, 0);
    }
    public void showList(String name, int minSalary) {
        if (minSalary != 0) {
            System.out.println("------------------------\n" + name + "s with a salary of more than " + minSalary);
        } else {
            System.out.println("------------------------\n" + name + "s:");
        }
        if (name.equalsIgnoreCase("intern developer")) {
            showList(internList, iCoun, minSalary);
        } else if (name.equalsIgnoreCase("junior developer")) {
            showList(juniorList, jCoun, minSalary);
        } else if (name.equalsIgnoreCase("senior developer")) {
            showList(seniorList, sCoun, minSalary);
        } else if (name.equalsIgnoreCase("team lead developer")) {
            showList(teamLeadList, tlCoun, minSalary);
        }
    }
    private static void showList(Developer[] list, int counter, int minSalary) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counter; i++) {
            if (list[i].getSalary() >= minSalary) {
                sb = sb.append(list[i].getName())
                        .append(": ")
                        .append(list[i].getBasicSalary())
                        .append(" -> ")
                        .append(list[i].getSalary())
                        .append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
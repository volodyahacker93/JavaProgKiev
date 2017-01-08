package Lection3.Task5;

public class StudentList {
    private Student[] list = new Student[10];
    private int counter;

    public void add(Student s){
        if (counter == list.length){
            Student[] list = new Student[this.list.length * 3 / 2 + 1];
            System.arraycopy(this.list, 0, list, 0, this.list.length);
            this.list = list;
        }
        list[counter++] = s;
    }

    public void delete(int n) {
        if (n >= 0 && n < list.length) {
            for (int i = n; i < list.length - 1; i++){
                list[i] = list[i+1];
            }
            list[list.length - 1] = null;
            counter--;
        }
    }

    public Student get(int n) {
        return list[n];
    }

    public void showAllList(){
        System.out.println("----------------------------");

        for (int i = 0; i < counter; i++){
            try {
                System.out.println((i + 1) + ") " + list[i].getName() + " " + list[i].getSurname() + ": " + list[i].getBirth());
            } catch (NullPointerException ex) {
                System.out.println("NullPointerException: " + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
        System.out.println("-------------------------------");
    }
}

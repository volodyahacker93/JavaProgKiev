package Lection3.Task6;

class Human implements Comparable {
    private int age;
    public Human(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    @Override
    public int compareTo(Object another) {
        Human h = (Human) another;
        if (age < h.age)
            return 1;
        else if (age > h.age)
            return -1;
        return 0;
    }
}
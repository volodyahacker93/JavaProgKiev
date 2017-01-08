package Lection7_8.object.Task_1_3;

import java.io.Serializable;

public class Human implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String surname;
    private String birth;
    private String sex;
    private transient String profession;
    private transient int height;
    private transient int weight;

    public Human() {

    }

    public Human(String name, String surname, String birth, String sex) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.sex = sex;
        height = 170;
        weight = 70;
    }

    @Override
    public Human clone() throws CloneNotSupportedException {
        Human h = (Human) super.clone();
        return h;
    }

    @Override
    public int hashCode() {
        return (name.hashCode() + surname.hashCode() + birth.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) {
            return false;
        }
        if(this == obj) {
            return true;
        }
        if(this.getClass() != obj.getClass()) {
            return false;
        }

        Human other = (Human) obj;
        return (this.name.equals(other.name)) && (this.surname.equals(other.surname)) &&
                (this.birth.equals(other.birth));
    }

    @Override
    public String toString() {
        return (name + " " + surname + ", " + sex + ", " + birth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

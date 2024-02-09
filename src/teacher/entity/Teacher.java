package teacher.entity;

import common.Person;

import java.io.Serializable;

public class Teacher  extends Person implements Serializable{

    private static final long serialVersionUID =1L;
    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return " Name-> " +
                getFirstName() +
                " " + " Surname-> "
                + getLastName() + " " +
                " Age-> " + getAge();

    }
}

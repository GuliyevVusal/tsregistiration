package student.entity;

import common.Person;

import java.io.Serializable;

public class Student extends Person implements Serializable {
    private static final long serialVersionUID =1L;

    private String firstName;
    private String lastName;
    private Integer age;
    private Integer studentNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return " Name-> " + firstName +
                " " + " Surname-> " +
                lastName + " "
                + " Age-> " + age +
                " " + " StudentNumber-> " +
                " " + studentNumber;
    }

}

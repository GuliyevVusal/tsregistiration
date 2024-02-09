package student.service;

import common.Db;
import common.RunnableAsMenu;
import student.entity.Student;

import java.util.Scanner;

public class StudentService implements RunnableAsMenu {


    private Student requireAndCreate() {
        Student student = new Student();
        System.out.print("Student name: ");
        student.setFirstName(new Scanner(System.in).nextLine());

        System.out.print("Student surname: ");
        student.setLastName(new Scanner(System.in).nextLine());

        System.out.print("Student age: ");
        student.setAge(new Scanner(System.in).nextInt());

        System.out.print("Student number: ");
        student.setStudentNumber(new Scanner(System.in).nextInt());
        System.out.println("-------------------------------");
        return student;

    }

    @Override
    public void initialize() {
        System.out.println("How many students will you register ? ");
        int countOfStudents = new Scanner(System.in).nextInt();
        Student[] students = new Student[countOfStudents];
        for (int i = 0; i < countOfStudents; i++) {
            System.out.println("Registiration number " + (i + 1));
            students[i] = requireAndCreate();
            System.out.println("Student added Successfully:");
            System.out.println("----------------------");

        }
        getAll();
        Db.students = students;

    }

    @Override
    public void initializeNew() {
        Student[] oldStudents = Db.students;
        System.out.println("How many students  would you like to add ?");
        int additionalStudents = new Scanner(System.in).nextInt();
        Student[] newStudents = new Student[oldStudents.length + additionalStudents];
        for (int i = 0; i < oldStudents.length; i++) {
            newStudents[i] = oldStudents[i];

        }
        for (int i = oldStudents.length; i < newStudents.length; i++) {
            newStudents[i] = requireAndCreate();
            System.out.println("Successfully created new student....\n");
        }
        Db.students = newStudents;
    }

    @Override
    public void update() {
        System.out.println("Which student would you like to update?? ");
        int updateStudentIndex = new Scanner(System.in).nextInt();
        if (updateStudentIndex > 0 && updateStudentIndex <= Db.students.length) {
            Student student = Db.students[updateStudentIndex - 1];
            System.out.println("Which field do you want to change? " +
                    "\n" + "Name: " + student.getFirstName() +
                    "\n" + "Surname: " + student.getLastName() +
                    "\n" + "Age: " + student.getAge() +
                    "\n" + "StudentNumber: " + student.getStudentNumber());
            System.out.println("Name/Suranme/Age/StudentNumber");
            String updateStudentFiled = new Scanner(System.in).nextLine();
            if (updateStudentFiled.equalsIgnoreCase("Name")) {
                System.out.print("Enter new student name: ");
                student.setFirstName(new Scanner(System.in).nextLine());
            } else if (updateStudentFiled.equalsIgnoreCase("Suranme")) {
                System.out.print("Enter new student surname: ");
                student.setLastName(new Scanner(System.in).nextLine());
            } else if (updateStudentFiled.equalsIgnoreCase("Age")) {
                System.out.print("Enter new student Age: ");
                student.setAge(new Scanner(System.in).nextInt());
            } else if (updateStudentFiled.equalsIgnoreCase("StudentNumber ")) {
                System.out.print("Enter new studentNumber");
                student.setStudentNumber(new Scanner(System.in).nextInt());

            }
            System.out.println("Successfully updaded new student information: " + student);
            System.out.println("---------------------------------------------------------");
        } else {
            System.out.println("You made the wrong choice!!! ");
        }
    }


    @Override
    public void delete() {
        System.out.println("Which student number do you want to delete?");
        int indexStudent = new Scanner(System.in).nextInt();
        if (indexStudent > 0 && indexStudent <= Db.students.length) {
            System.out.println("Student has deleted Successfully: " + "number" + " "
                    + indexStudent + "-" + Db.students[indexStudent - 1]);
            System.out.println("----------------------------------------------------------------");
            Db.students[indexStudent - 1] = null;
        } else {
            System.out.println("please choose right!!!!\n");
        }
    }

    @Override
    public void find() {
        System.out.println("Enter name or suranme Student: ");
        String textStudent = new Scanner(System.in).nextLine();
        for (Student s : Db.students) {
            if (s.getFirstName().equalsIgnoreCase(textStudent) || s.getLastName().equalsIgnoreCase(textStudent)) {
                System.out.println(s + " ");
                System.out.println("--------------------------");
            }
        }
    }

    @Override
    public void getAll() {
        Student[] students = Db.students;
        System.out.println("Registered Students: ");
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) continue;
            System.out.println((i + 1) + "." + "Students: " + students[i]);
            System.out.println("----------------------------");
        }
    }
}




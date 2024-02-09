package teacher.service;

import common.Db;
import common.RunnableAsMenu;
import file.FileUtility;
import teacher.RegistirationException;
import teacher.entity.Teacher;

import java.util.Scanner;

public class TeacherService implements RunnableAsMenu {


    private Teacher requireAndCreate() {
        Teacher teacher = new Teacher();


        System.out.print("Teacher name: ");
        teacher.setFirstName(new Scanner(System.in).nextLine());

        System.out.print("Teacher surname: ");
        teacher.setLastName(new Scanner(System.in).nextLine());

        System.out.print("Teacher age: ");
        teacher.setAge(new Scanner(System.in).nextInt());

        System.out.print("Teacher salary: ");
        teacher.setSalary(new Scanner(System.in).nextDouble());
        System.out.println("Teacher added Successfully:");
        System.out.println("----------------------");

        return teacher;

    }

    @Override
    public void initialize() throws RegistirationException {
        System.out.println("How many teachers will you register ? ");
        int countOfTeachers = new Scanner(System.in).nextInt();
        Teacher[] teachers = new Teacher[countOfTeachers];
        for (int i = 0; i < countOfTeachers; i++) {
            System.out.println("Registiration number " + (i + 1));
            teachers[i] = requireAndCreate();
            System.out.println("Teacher added Successfully:");
            System.out.println("----------------------");
        }
        getAll();
        Db.teachers = teachers;
        try {
            fileUpdate("teachers.obj");
        } catch (Exception e) {
            throw new RegistirationException("Yalnis secim etdiniz: ");
        }
    }

    @Override
    public void initializeNew() {
        Teacher[] oldTeachers = Db.teachers;
        System.out.println("How many teachers would you like to add?? ");
        int additionalTeacher = new Scanner(System.in).nextInt();
        Teacher[] newTeachers = new Teacher[oldTeachers.length + additionalTeacher];
        for (int i = 0; i < oldTeachers.length; i++) {
            newTeachers[i] = oldTeachers[i];
        }
        for (int i = oldTeachers.length; i < newTeachers.length; i++) {
            newTeachers[i] = requireAndCreate();
            System.out.println("Successfully created new teacher....\n");
        }
        Db.teachers = newTeachers;
        try {
            fileUpdate("teachers.obj");
        } catch (Exception e) {

        }
    }

    @Override
    public void update() {
        System.out.println("Which teacher would you like to update? ");
        int updateIndexTeacher = new Scanner(System.in).nextInt();
        if (updateIndexTeacher > 0 && updateIndexTeacher <= Db.teachers.length) {
            Teacher teacher = Db.teachers[updateIndexTeacher - 1];
            System.out.println("Which field do you want to change ? " +
                    "\n" + "Name: " + teacher.getFirstName() +
                    "\n" + "Surname: " + teacher.getLastName() +
                    "\n" + "Age: " + teacher.getAge() +
                    "\n" + "Salary: " + teacher.getSalary());
            System.out.println("Name/Surname/Age/Salary");
            String updateFieldTeacher = new Scanner(System.in).nextLine();
            if (updateFieldTeacher.equalsIgnoreCase("Name")) {
                System.out.print("Enter new teacher name: ");
                teacher.setFirstName(new Scanner(System.in).nextLine());
            } else if (updateFieldTeacher.equalsIgnoreCase("Surname")) {
                System.out.print("Enter new teacher surname: ");
                teacher.setLastName(new Scanner(System.in).nextLine());
            } else if (updateFieldTeacher.equalsIgnoreCase("Age")) {
                System.out.print("Enter new teacher age: ");
                teacher.setAge(new Scanner(System.in).nextInt());
            } else if (updateFieldTeacher.equalsIgnoreCase("Salary")) {
                System.out.print("Enter new teacher salary: ");
                teacher.setSalary(new Scanner(System.in).nextDouble());
            }
            System.out.println("Successfully updaded new teacher information: " + teacher);
            System.out.println("---------------------------------------------------------");
        } else {
            System.out.println("You made the wrong choice!!! ");
        }
        try {
            fileUpdate("teachers.obj");
        } catch (Exception e) {
        }

    }


    @Override
    public void delete() {
        System.out.println("Which teacher number do you want to delete?");
        int indexTeacher = new Scanner(System.in).nextInt();
        if (indexTeacher > 0 && indexTeacher <= Db.teachers.length) {
            System.out.println("Teacher has deleted Successfully: " + "number" + " "
                    + indexTeacher + "-" + Db.teachers[indexTeacher - 1]);
            System.out.println("----------------------------------------------------------------");
            Db.teachers[indexTeacher - 1] = null;
        } else {
            System.out.println("please choose right!!!!\n");
        }
        try {
            fileUpdate("teachers.obj");
        } catch (Exception e) {

        }


    }

    @Override
    public void find() {
        Teacher[] teachers = Db.teachers;
        System.out.println("Enter name or surname of teacher ");
        String textTeacher = new Scanner(System.in).nextLine();
        for (Teacher t : teachers) {
            if (t == null) continue;
            if (t.getFirstName().equalsIgnoreCase(textTeacher) || t.getLastName().equalsIgnoreCase(textTeacher)) {
                System.out.println(t + " ");
                System.out.println("--------------------------");

            }
        }
    }

    @Override
    public void getAll() {
        Teacher[] teachers = Db.teachers;
        System.out.println("Registered Teachers: ");
        for (int i = 0; i < Db.teachers.length; i++) {
            if (teachers[i] == null) continue;
            System.out.println((i + 1) + "." + "Teacher: " + teachers[i]);
            System.out.println("----------------------------");
        }
    }

    public static void fileUpdate(String fayl) throws Exception {
        FileUtility.writeObjectToFile(Db.teachers, "teachers.obj");
    }
}

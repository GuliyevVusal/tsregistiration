import common.Db;
import common.EXCEPTIONS;
import common.SERVICE_TYPE;
import file.FileUtility;
import teacher.entity.Teacher;

public class Main {

    public static void main(String[] args) throws Exception {

        try {
            Object o = FileUtility.readObject("teachers.obj");
            Db.teachers = (Teacher[]) o;

            for (Teacher teacher : Db.teachers) {
                System.out.println(teacher);
            }
            SERVICE_TYPE serviceType = SERVICE_TYPE.TEACHER;
            serviceType.start();
            FileUtility.writeObjectToFile(Db.teachers, "teachers.obj");
        } catch (Exception ex) {
            EXCEPTIONS.TEACHER_REG_EX.throwEx();
        }

    }

}








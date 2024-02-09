package common;

import student.service.StudentService;
import teacher.RegistirationException;
import teacher.service.TeacherService;

public enum SERVICE_TYPE {
    STUDENT(new StudentService(), 1),
    TEACHER(new TeacherService(), 2),
    UNKOWN(null, -1);
    RunnableAsMenu menu;
    int number;

    SERVICE_TYPE(RunnableAsMenu menu, int number) {
        this.menu = menu;
        this.number = number;
    }

    public void start() throws RegistirationException {
        this.menu.showMenu();
    }

    public static SERVICE_TYPE getServiceByNumber(int number) {
        SERVICE_TYPE[] values = SERVICE_TYPE.values();
        for (int i = 0; i < values.length; i++) {
            SERVICE_TYPE serviceType = values[i];
            if (serviceType.number == number) {
                return serviceType;
            }
        }
        return UNKOWN;
    }

}

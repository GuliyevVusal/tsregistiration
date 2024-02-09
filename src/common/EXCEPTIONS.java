package common;

import teacher.RegistirationException;

public enum EXCEPTIONS {

    TEACHER_REG_EX(new RegistirationException("Qeydiyyat zamani Xeta bas verdi"),1);

    int code;

    private final Exception exception;

    EXCEPTIONS(Exception exception, int code) {
        this.exception = exception;
        this.code = code;

    }

    public void throwRuntimeException() {
        throw new RuntimeException(exception);
    }

    public void throwEx() throws Exception {
        throw exception;
    }
}

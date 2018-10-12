package hibernate.lesson8.homework8_1.exception;

public class InternalServerError extends Exception {
    private String classLoc;
    private String methodLoc;
    private String reason;

    public InternalServerError(String classLoc, String methodLoc, String reason, String message) {
        super(message);
        this.classLoc = classLoc;
        this.methodLoc = methodLoc;
        this.reason = reason;
    }

    public String getClassLoc() {
        return classLoc;
    }

    public String getMethodLoc() {
        return methodLoc;
    }

    public String getReason() {
        return reason;
    }
}

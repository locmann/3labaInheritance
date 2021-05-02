package exception;

public class MyException extends RuntimeException {
    protected String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

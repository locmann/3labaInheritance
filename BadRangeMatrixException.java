package exception;

public class BadRangeMatrixException extends MyException {
    public BadRangeMatrixException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}

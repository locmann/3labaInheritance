package exception;

public class NonSuitableMatrixException extends MyException{

    public NonSuitableMatrixException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}

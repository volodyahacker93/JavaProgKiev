package Lection3.Task3;

public class ParseIntException extends Exception {

    public ParseIntException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "ParseIntException: " + super.getMessage();
    }
}

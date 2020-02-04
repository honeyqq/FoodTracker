package ua.com.foodtrackerfinal.exception;

public class UsernameFoundException extends RuntimeException {
    private String message;

    public UsernameFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

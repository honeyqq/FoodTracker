package ua.com.foodtrackerfinal.Exception;

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

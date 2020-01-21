package ua.com.foodtrackerfinal.Exception;

public class PasswordsException extends Exception {
    private String message;

    public PasswordsException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

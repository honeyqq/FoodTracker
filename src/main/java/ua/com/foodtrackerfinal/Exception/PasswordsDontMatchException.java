package ua.com.foodtrackerfinal.Exception;

public class PasswordsDontMatchException extends Exception {
    private String name;

    public PasswordsDontMatchException(String name) {
        this.name = name;
    }
}

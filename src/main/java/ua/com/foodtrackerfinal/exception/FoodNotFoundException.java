package ua.com.foodtrackerfinal.exception;

public class FoodNotFoundException extends Exception {
    public FoodNotFoundException() {
    }

    public FoodNotFoundException(String message) {
        super(message);
    }
}

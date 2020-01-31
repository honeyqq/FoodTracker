package ua.com.foodtrackerfinal.utility;

public interface RegexContainer {
    String NAME_REGEX = "^[A-Z][a-z]{2,20}$";
    String NAME_REGEX_UA = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{2,20}$";
    String USERNAME_REGEX = "^[a-z0-9_-]{3,15}$";
}

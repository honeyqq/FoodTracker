package ua.com.foodtrackerfinal.dto;

import javax.validation.constraints.NotNull;

public class UserRegistrationDto {

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private int height;

    @NotNull
    private int weight;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}

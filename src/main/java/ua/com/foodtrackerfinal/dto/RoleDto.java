package ua.com.foodtrackerfinal.dto;

public enum RoleDto {
    USER("USER"),
    ADMIN("ADMIN");

    RoleDto(String role) {
    }

    private Long id;
    private String role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

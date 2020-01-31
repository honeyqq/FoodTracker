package ua.com.foodtrackerfinal.entity;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import ua.com.foodtrackerfinal.utility.RegexContainer;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"username"})})
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Pattern(regexp = RegexContainer.NAME_REGEX_UA, message = "Invalid ua name")
    @Column(name = "name_ua", nullable = false)
    private String nameUA;

    @Pattern(regexp = RegexContainer.NAME_REGEX, message = "Invalid en name")
    @Column(name = "name_en", nullable = false)
    private String nameEN;

    @Pattern(regexp = RegexContainer.USERNAME_REGEX, message = "Invalid username")
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @Size(min = 3, max = 100)
    private String password;

    @Column(nullable = false)
    @Size(min=2,max = 3)
    private String height;

    @Column(nullable = false)
    @Size(min=2,max = 3)
    private String weight;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}

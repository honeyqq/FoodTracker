package ua.com.foodtrackerfinal.repository;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foodtrackerfinal.entity.user.Roles;
import ua.com.foodtrackerfinal.entity.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @NotNull Optional<User> findById(@NotNull Long id);

    @NotNull List<User> findAll();

    List<User> findByAuthoritiesContaining(Roles roles);
}

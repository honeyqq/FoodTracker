package ua.com.foodtrackerfinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.com.foodtrackerfinal.dto.UserRegistrationDto;
import ua.com.foodtrackerfinal.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> save (UserRegistrationDto userRegistrationDto);
}

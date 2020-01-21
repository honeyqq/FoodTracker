package ua.com.foodtrackerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.foodtrackerfinal.Exception.UsernameFoundException;
import ua.com.foodtrackerfinal.dto.RoleDto;
import ua.com.foodtrackerfinal.dto.UserDto;
import ua.com.foodtrackerfinal.entity.Role;
import ua.com.foodtrackerfinal.entity.User;
import ua.com.foodtrackerfinal.repository.UserRepository;

import java.util.Collections;
import java.util.Optional;

@Service
public class RegistrationService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public RegistrationService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public boolean registerUser(User user) throws UsernameFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(user.getUsername());
        if (optionalUser.isPresent()) {
            throw new UsernameFoundException("Account with this email already exists!");
        }

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        newUser.setRole(new Role("USER"));
        newUser.setHeight(user.getHeight());
        newUser.setWeight(user.getWeight());
        userRepository.save(newUser);
        System.out.println("New user was created"); //TODO delete this line
        return true;
    }
}

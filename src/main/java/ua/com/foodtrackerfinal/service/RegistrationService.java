package ua.com.foodtrackerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.foodtrackerfinal.Exception.UsernameFoundException;
import ua.com.foodtrackerfinal.dto.UserRegistrationDto;
import ua.com.foodtrackerfinal.entity.Role;
import ua.com.foodtrackerfinal.entity.User;
import ua.com.foodtrackerfinal.repository.UserRepository;

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

    public boolean registerUser(UserRegistrationDto userRegistrationDto) throws UsernameFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userRegistrationDto.getUsername());
        if (optionalUser.isPresent()) {
            throw new UsernameFoundException("Account with this email already exists!");
        }

        User newUser = new User();
        newUser.setUsername(userRegistrationDto.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userRegistrationDto.getPassword()));
        newUser.setRole(new Role("USER"));
        newUser.setHeight(userRegistrationDto.getHeight());
        newUser.setWeight(userRegistrationDto.getWeight());
        userRepository.save(newUser);
        return true;
    }
}

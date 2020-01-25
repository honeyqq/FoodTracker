package ua.com.foodtrackerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.com.foodtrackerfinal.Exception.UsernameFoundException;
import ua.com.foodtrackerfinal.dto.UserDto;
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

    public boolean registerUser(UserDto userDto) throws UsernameFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());
        if (optionalUser.isPresent()) {
            throw new UsernameFoundException("Account with this email already exists!");
        }

        User newUser = new User();
        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        newUser.setRole(new Role("USER"));
        newUser.setHeight(userDto.getHeight());
        newUser.setWeight(userDto.getWeight());
        userRepository.save(newUser);
        return true;
    }
}

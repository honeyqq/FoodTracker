package ua.com.foodtrackerfinal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import ua.com.foodtrackerfinal.Exception.PasswordsException;
import ua.com.foodtrackerfinal.dto.LoginDto;
import ua.com.foodtrackerfinal.entity.User;
import ua.com.foodtrackerfinal.repository.UserRepository;

@Controller
public class LoginService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public LoginService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User loginUser(LoginDto loginUser) throws PasswordsException {
        User user = userRepository.findByUsername(loginUser.getUsername())
                .orElseThrow(() -> new PasswordsException("Account not found in database"));

        return checkCredentials(loginUser, user);
    }


    private User checkCredentials(LoginDto loginDto, User userFromDB) throws PasswordsException {
        if (bCryptPasswordEncoder.matches(loginDto.getPassword(), userFromDB.getPassword())) {
            return userFromDB;
        } else {
            throw new PasswordsException("Passwords do not match!");
        }
    }
}

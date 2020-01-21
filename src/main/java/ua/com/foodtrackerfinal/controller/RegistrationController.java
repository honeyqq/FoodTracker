package ua.com.foodtrackerfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.foodtrackerfinal.Exception.PasswordsException;
import ua.com.foodtrackerfinal.Exception.UsernameFoundException;
import ua.com.foodtrackerfinal.dto.UserDto;
import ua.com.foodtrackerfinal.entity.User;
import ua.com.foodtrackerfinal.service.RegistrationService;
import ua.com.foodtrackerfinal.service.UserService;

@Controller
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String getRegistration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUser(User user) throws UsernameFoundException {
        registrationService.registerUser(user);
        return "redirect:/login";
    }
}

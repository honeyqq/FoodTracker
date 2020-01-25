package ua.com.foodtrackerfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.foodtrackerfinal.Exception.UsernameFoundException;
import ua.com.foodtrackerfinal.dto.UserDto;
import ua.com.foodtrackerfinal.service.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @ModelAttribute("user")
    public UserDto UserDto() {
        return new UserDto();
    }

    @GetMapping
    public String getRegistration() {
        return "registration";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result)
            throws UsernameFoundException {

        if (result.hasErrors()) {
            return "registration";
        }

        registrationService.registerUser(userDto);

        return "redirect:/registration?success";
    }
}

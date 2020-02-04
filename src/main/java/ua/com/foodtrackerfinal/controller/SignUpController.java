package ua.com.foodtrackerfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.foodtrackerfinal.entity.user.User;
import ua.com.foodtrackerfinal.service.UserService;

import javax.validation.Valid;

@Controller
@Slf4j
public class SignUpController {

    private PasswordEncoder passwordEncoder;
    private UserService userService;

    @Autowired
    public SignUpController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/signup")
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
        log.info("getting signup page");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("signup");

        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult result) {
        log.info("trying to register new user");
        if (result.hasErrors()) {
            log.error("Invalid data during registration");
            modelAndView.addObject("failureMessage", "signup.label.error");
            modelAndView.setViewName("signup");
        } else {
            try {
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                user.setAge(user.getAge());
                user.setHeight(user.getHeight());
                user.setWeight(user.getWeight());
                user.setCalories(userService.calculateCaloriesForPerson(user));
                userService.setDefaultParams(user);
                userService.saveOrUpdate(user);
                modelAndView.setViewName("redirect:/login");
            } catch (Exception e) {
                log.error("username already exist");
                modelAndView.addObject("failureMessage", "signup.label.alreadyRegistered");
                modelAndView.setViewName("signup");
            }
        }
        return modelAndView;
    }
}

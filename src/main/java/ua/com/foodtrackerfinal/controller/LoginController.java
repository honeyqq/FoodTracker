package ua.com.foodtrackerfinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.foodtrackerfinal.Exception.PasswordsException;
import ua.com.foodtrackerfinal.dto.LoginDto;
import ua.com.foodtrackerfinal.entity.User;
import ua.com.foodtrackerfinal.service.LoginService;
import ua.com.foodtrackerfinal.service.UserService;

import javax.validation.Valid;

@Controller
public class LoginController {

    private UserService userService;
    private LoginService loginService;

    @Autowired
    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }


    @GetMapping("/login")
    public String getLoginPage() {
        System.out.println("LOGIN GET"); //TODO delete this line
        return "login";
    }

    //    public String loginUser(@ModelAttribute("login_atr") Map<Integer, String> request) throws PasswordsException {
    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@Valid @RequestBody LoginDto loginDto) throws PasswordsException {
        System.out.println("LOGIN POST"); //TODO delete this line
        User user = new User();
        if (loginDto != null) {
            user = loginService.loginUser(loginDto);
        }
//        return "redirect:/home";//TODO i think it doesn't redirect properly
        return ResponseEntity.ok(user);
    }

    @ExceptionHandler(PasswordsException.class)
    public ResponseEntity handlePermissionException(PasswordsException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

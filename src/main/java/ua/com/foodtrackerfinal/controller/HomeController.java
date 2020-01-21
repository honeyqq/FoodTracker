package ua.com.foodtrackerfinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String getHomePage() {
        return "home";
    }

//    @GetMapping("/admin")
//    public String admin() {
//        return "admin";
//    }

//    @GetMapping("/user")
//    public String user() {
//        return "user";
//    }
}

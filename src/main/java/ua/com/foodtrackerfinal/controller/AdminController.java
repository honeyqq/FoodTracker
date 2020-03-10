package ua.com.foodtrackerfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {

    @GetMapping("/")
    public String adminPage() {
        log.info("getting admin page");
        return "admin";
    }
}

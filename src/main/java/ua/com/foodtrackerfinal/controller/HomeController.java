package ua.com.foodtrackerfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @GetMapping({"/", "/index"})
    public String welcomePage() {
        log.info("getting index page");
        return "index";
    }

    @GetMapping("/error")
    public String error404Page() {
        log.info("getting error page");
        return "error";
    }
}

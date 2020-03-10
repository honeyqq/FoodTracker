package ua.com.foodtrackerfinal.controller;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.com.foodtrackerfinal.entity.user.User;
import ua.com.foodtrackerfinal.service.FoodService;
import ua.com.foodtrackerfinal.service.UserService;

@Slf4j
@Controller
@RequestMapping("/user/*")
public class UserController {

    private static final int NUMBER_OF_DISHES_ON_PAGE = 10;

    private UserService userService;
    private FoodService foodService;

    @Autowired
    public UserController(UserService userService, FoodService foodService) {
        this.userService = userService;
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String userPage() {
        log.info("getting user page");
        return "user";
    }

    @GetMapping("/foodlist") //TODO 2 params
    public ModelAndView foodListPage(@NotNull ModelAndView modelAndView, @RequestParam Integer page) {
        log.info("getting foodList page number " + page);
        Pageable pageable = PageRequest.of(page - 1, NUMBER_OF_DISHES_ON_PAGE);
        modelAndView.addObject("dishes", foodService.findAll(pageable));
        modelAndView.setViewName("foodlist");
        return modelAndView;
    }

    @GetMapping("/userprofile")
    public ModelAndView getProfile(@NotNull ModelAndView modelAndView, @NotNull User user) {
        log.info("===> user profile");
        modelAndView.addObject("user", userService.findUserById(user.getId()));
        modelAndView.setViewName("userprofile");
        return modelAndView;
    }
}

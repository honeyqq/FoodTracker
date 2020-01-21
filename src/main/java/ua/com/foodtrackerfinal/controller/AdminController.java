//package ua.com.foodtrackerfinal.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import ua.com.foodtrackerfinal.service.UserService;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//
//
//    private UserService userService;
//
//    @Autowired
//    public AdminController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String userList(Model model) {
//        model.addAttribute("allUsers", userService.allUsers());
//        return "admin";
//    }
//
//    @PostMapping("/admin")
//    public String  deleteUser(@RequestParam(required = true, defaultValue = "" ) Long userId,
//                              @RequestParam(required = true, defaultValue = "" ) String action,
//                              Model model) {
//        if (action.equals("delete")){
//            userService.deleteUser(userId);
//        }
//        return "redirect:/admin";
//    }
//}

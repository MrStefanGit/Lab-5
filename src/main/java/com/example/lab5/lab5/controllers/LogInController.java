package com.example.lab5.lab5.controllers;


import com.example.lab5.lab5.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LogInController {

    private final UserService userService;

    public LogInController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String logInForm(Model model){
        return "login";
    }

    @PostMapping
    public String logInUser(Model model, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        if (userService.checkLogin(username, password)) {
            model.addAttribute("username", username);
            return "redirect:/products";
        }
        model.addAttribute("InvalidLogin", "Username or password incorrect!");
        return "redirect:/login";
    }
}

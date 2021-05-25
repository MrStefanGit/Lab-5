package com.example.lab5.lab5.controllers;

import com.example.lab5.lab5.domains.User;
import com.example.lab5.lab5.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {

    private final UserService userService;

    @Autowired
    public SignUpController(UserService userService) {this.userService = userService;}


    @GetMapping
    public String signUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        if (userService.userExists(user)) {
            model.addAttribute("usernameExists", "Username Already exists!");
            return "redirect:/signup";
        } else {
            user.setPassword(userService.getHash(user.getPassword()));
            userService.save(user);
            return "login";
        }
    }
}

package ru.hard2code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.hard2code.model.User;
import ru.hard2code.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    final UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping
    public String addUser(User user, Model model) {
        userService.saveUser(user);
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }
}

package ru.hard2code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String requestParamsHome(
            @RequestParam(value = "color", defaultValue = "cyan") String color,
            @RequestParam(value = "username", defaultValue = "Default username")
            String username, Model model) {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "home";
    }

    @GetMapping("{color}/{username}")
    public String pathParamsHome(@PathVariable("color") String color,
                                 @PathVariable("username") String username,
                                 Model model) {
        model.addAttribute("username", username);
        model.addAttribute("color", color);
        return "home";
    }
}

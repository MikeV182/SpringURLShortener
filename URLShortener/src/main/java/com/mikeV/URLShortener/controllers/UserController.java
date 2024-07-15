package com.mikeV.URLShortener.controllers;

import com.mikeV.URLShortener.model.UserInput;
import com.mikeV.URLShortener.services.ShortURLGenerator;
import com.mikeV.URLShortener.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String userPage(Model model) {
        model.addAttribute("userPage", userService.getUserInputById(0L));
        return "userPage";
    }

    @PostMapping("/generate")
    public String generateURL(UserInput input) {
        userService.addURL(input);
        ShortURLGenerator.generateShortURL(input);
        return "redirect:/";
    }
}

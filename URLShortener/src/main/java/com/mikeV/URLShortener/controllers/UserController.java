package com.mikeV.URLShortener.controllers;

import com.mikeV.URLShortener.model.UserInput;
import com.mikeV.URLShortener.services.ShortURLGenerator;
import com.mikeV.URLShortener.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String userPage() {
        return "userPage";
    }

    @GetMapping("/generated/{id}")
    public String generatedURL(@PathVariable Long id, Model model) {
        model.addAttribute("resultPage", userService.getUserInputById(id));
        return "resultPage";
    }

    @GetMapping("/{token}")
    public String redirectByToken(@PathVariable String token) {
        UserInput user = userService.getUserByToken(token);
        return "redirect:"+user.getOriginURL();
    }

    @PostMapping("/generate")
    public String generateURL(UserInput input) {
        userService.add(input);
        ShortURLGenerator.generateShortURL(input);
        userService.update(input);
        return "redirect:/generated/"+input.getId();
    }
}

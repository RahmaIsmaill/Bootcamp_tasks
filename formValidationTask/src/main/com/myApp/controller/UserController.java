package main.com.myApp.controller;

import main.com.myApp.model.User;
import main.com.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "formPage";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("user") User user,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "formPage";
        }

        userService.saveUser(user);
        model.addAttribute("user", user);
        return "resultPage";
    }
}

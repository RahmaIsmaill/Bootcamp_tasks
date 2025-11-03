package main.com.myApp.controller;

import main.com.myApp.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {


    @RequestMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("user") User user, Model model) {
      model.addAttribute("user", user);

        return "resultPage";
    }
}

package main.com.myApp.controller;

import main.com.myApp.model.User;
import main.com.myApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showHomePage() {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(HttpServletRequest request, Model model) {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String city = request.getParameter("city");


        LocalDate dateOfBirth = LocalDate.parse( request.getParameter("dateOfBirth"));

        Date sqlDate = null;
        if (dateOfBirth != null) {
            sqlDate = Date.valueOf(dateOfBirth);
        }

        User user = new User(firstName, lastName, email, sqlDate, city);
        userService.saveUser(user);

        model.addAttribute("user", user);

        return "resultPage";
    }
}

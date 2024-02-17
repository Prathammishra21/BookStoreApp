package com.bookStore.controller;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import javax.servlet.http.HttpSession;
''
@Controller
public class HomeController {

    @Autowired
    private HttpSession httpSession; // Autowire the HttpSession

    @GetMapping("/register") // Assuming this is the endpoint for the registration page
    public String showRegisterPage(Model model) {
        // Your logic to show the registration page
        // Example: model.addAttribute("someData", someData);

        // Set the message attribute in the session
        httpSession.setAttribute("msg", "Your success message here");

        return "register"; //
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @ModelAttribute
    public void commonUser(Principal p, Model m) {
        if (p != null) {
            String email = p.getName();
            User user = userRepo.findByEmail(email);
            m.addAttribute("user", user);
        }

    }



    @GetMapping("/")
    public String register() {
        return "register";
    }

    @GetMapping("/signin")
    public String login() {
        return "login";
    }

    @GetMapping("/user/profile")
    public String profile(Principal p, Model m) {
        String email = p.getName();
        User user = userRepo.findByEmail(email);
        m.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/user/home")
    public String home() {
        return "home";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session, Model m) {

        // System.out.println(user);

        User u = userService.saveUser(user);

        if (u != null) {
            // System.out.println("save sucess");
            session.setAttribute("msg", "Register successfully");

        } else {
            // System.out.println("error in server");
            session.setAttribute("msg", "Something wrong server");
        }
        return "redirect:/register";
    }

}

package com.bookStore.controller;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class HomeController {

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

    @GetMapping("/about")
    public String index() {
        return "/base_Profile/about";
    }

    @GetMapping("/")
    public String register() {
        return "/Login_Register_Page/register";
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
        return "/base_Profile/profile";
    }

    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute User user, BindingResult result, HttpSession session, Model m) {
        if (result.hasErrors()) {
            return "/Login_Register_Page/register";
        }
        User u = userService.saveUser(user);

        if (u != null) {
            session.setAttribute("msg", "Registered successfully");

        } else {
            session.setAttribute("msg", "Something gone wrong");
        }
        return "/Login_Register_Page/register";
    }
}
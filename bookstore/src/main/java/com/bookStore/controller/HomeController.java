package com.bookStore.controller;

import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import com.bookStore.service.BookService;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @Autowired
    private  UserService userService;
    private BookService service;
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
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
    return "register";
    }

@PostMapping("/saveUser")
    public String saveUser(@ModelAttribute User user, HttpSession session){
    //System.out.println(user);
    User u = userService.saveUser(user);
    if(u!=null){
      //  System.out.println("User Saved successfully");
        session.setAttribute("msg", "Registered successfully");
    }else{
       // System.out.println("Error");
        session.setAttribute("msg","Something went wrong");
    }
    return "redirect:/register";
    }
}

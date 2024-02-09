package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
@GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/register")
    public String register(){
    return "register";
    }

    @GetMapping("/login")
    public String login(){
    return "login";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list=service.getAllBook();
        return new ModelAndView("bookList","book",list);
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model)
    {
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @GetMapping("/about_us")
    public String aboutus() {
        return "aboutus";
    }
@PostMapping("/saveUser")
    public String saveUser(){
    System.out.println(user);
    return "register";
    }

}

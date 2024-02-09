package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.entity.User;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private  UserService userService;
    private BookService service;


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
        MyBookListService myBookService = new MyBookListService();
        List<MyBookList>list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }

    @GetMapping("/about_us")
    public String aboutus() {
        return "aboutus";
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
        session.setAttribute("msg","Invalid operation");
    }
    return "redirect:/register";
    }
}

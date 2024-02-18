package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.entity.User;
import com.bookStore.repository.UserRepo;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import com.bookStore.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;



@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBook();
        return new ModelAndView("bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/available_books";
    }

    @GetMapping("/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "myBooks";
    }

    @GetMapping("/about_us")
    public String aboutus() {
        return "aboutus";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getEdition(), b.getPrice(), b.getPublisher());
        myBookService.saveMyBooks(mb);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/available_books";
    }

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
            return "home";
        }

        @PostMapping("/register") // Updated mapping to handle user registration
        public String saveUser(@ModelAttribute User user, HttpSession session) {
            try {
                // Attempt to save the user
                User savedUser = userService.saveUser(user);

                if (savedUser != null) {
                    // User registration successful
                    session.setAttribute("msg", "Registration successful");
                    return "redirect:/signin"; // Redirect to the login page after successful registration
                } else {
                    // User registration failed
                    session.setAttribute("msg", "Something went wrong during registration");
                    return "redirect:/register"; // Redirect back to the registration page
                }
            } catch (Exception e) {
                // Log the exception for debugging purposes
                e.printStackTrace();
                session.setAttribute("msg", "Internal server error"); // Provide a generic error message
                return "redirect:/register"; // Redirect back to the registration page
            }
        }

    }

package com.bookStore.controller;

import com.bookStore.entity.Book;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;



@Controller
public class BookController {

    @Autowired
    private BookService service;

    @Autowired
    private MyBookListService myBookService;

    @GetMapping("user/home")
    public String home() {
        return "/home_page/home";
    }

    @GetMapping("/user/book_register")
    public String bookRegister() {
        return "/Book_Pages/bookRegister";
    }

    @GetMapping("/user/available_books")
    @ResponseBody
    public ModelAndView getAllBook() {
        List<Book> list = service.getAllBook();
        return new ModelAndView("/Book_Pages/bookList", "book", list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b) {
        service.save(b);
        return "redirect:/user/Book_Pages/available_books";
    }

    @GetMapping("/user/my_books")
    public String getMyBooks(Model model) {
        List<MyBookList> list = myBookService.getAllMyBooks();
        model.addAttribute("book", list);
        return "/Book_Pages/myBooks";
    }


    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id) {
        Book b = service.getBookById(id);
        MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getEdition(), b.getPrice(), b.getPublisher());
        myBookService.saveMyBooks(mb);
        return "redirect:/user/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book b = service.getBookById(id);
        model.addAttribute("book", b);
        return "/Book_Pages/bookEdit";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id) {
        service.deleteById(id);
        return "redirect:/user/available_books";
    }
}

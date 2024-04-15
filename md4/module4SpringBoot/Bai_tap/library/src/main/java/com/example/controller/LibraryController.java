package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import com.example.service.IBorrowedCardService;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Controller
@RequestMapping("")
public class LibraryController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IBorrowedCardService borrowedCardService;
    @GetMapping("")
    public String showListOfBook(Model model, Pageable pageable){
        List<Book> bookList = bookService.findAll();
        model.addAttribute("bookList",bookList );
        return "/view/list";
    }
    @GetMapping("detail")
    public String showDetail(Model model, @RequestParam("id") Integer id){
        model.addAttribute("book", bookService.findById(id));
        return "/view/detail";
    }
    @GetMapping("borrow")
    public String showFormBorrow(Model model, @RequestParam("id") Integer id){
        model.addAttribute("book", bookService.findById(id));
        return "/view/borrow";
    }
    @PostMapping("borrow")
    public String borrow(@RequestParam("book_id") Integer bookId,
                         @RequestParam("borrowed_card_id") Integer borrowedCardId,
                         @RequestParam("user_id") Integer userId){
        borrowedCardService.borrowBook(borrowedCardId,bookId,userId);
        return "redirect:";
    }
}

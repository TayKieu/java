package com.example.service;

import com.example.model.Book;
import com.example.repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepo bookRepo;
    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    public boolean save(Book book) {
        Book newBook = bookRepo.save(book);
        if(newBook != null){
            return true;
        }
        return false;
    }

    @Override
    public Page<Book> findAllPage(Pageable pageable) {
        return bookRepo.findAll(pageable);
    }
}

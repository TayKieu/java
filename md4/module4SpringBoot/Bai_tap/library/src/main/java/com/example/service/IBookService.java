package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Integer id);
    boolean save(Book book);
    Page<Book> findAllPage(Pageable pageable);
}

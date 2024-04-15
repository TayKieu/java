package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Page<Blog> findAll(Pageable pageable, String searchName);
    List<Blog> search(String searchName);
    Blog findById(int id);
    boolean save(Blog blog);
}

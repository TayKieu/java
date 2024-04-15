package com.example.service;

import com.example.model.Blog;
import com.example.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepo blogRepo;
    @Override
    public List<Blog> findAll() {
        return blogRepo.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String searchName) {
        return blogRepo.findBlogsByTitleContaining(pageable, searchName);
    }

    @Override
    public List<Blog> search(String searchName) {
        return null;
    }

    @Override
    public Blog findById(int id) {
        return blogRepo.findById(id);
    }

    @Override
    public boolean save(Blog blog) {
        Blog newBlog = blogRepo.save(blog);
        if (newBlog!=null){
            return  true;
        }
        return false;
    }
}

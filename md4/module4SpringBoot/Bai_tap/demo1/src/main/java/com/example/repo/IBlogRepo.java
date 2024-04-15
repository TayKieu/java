package com.example.repo;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepo extends JpaRepository<Blog,Integer>{
//    List<Blog> findBlogsBy(String name);
    Page<Blog> findBlogsByTitleContaining(Pageable pageable, String searchName);

    Blog findById(int id);
}

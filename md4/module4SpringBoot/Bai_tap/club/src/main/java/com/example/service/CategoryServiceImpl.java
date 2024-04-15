package com.example.service;

import com.example.model.Category;
import com.example.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService{
    @Autowired
    private ICategoryRepo categoryRepo;
    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}

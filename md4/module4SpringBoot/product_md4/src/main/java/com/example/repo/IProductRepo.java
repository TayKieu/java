package com.example.repo;

import com.example.model.Category;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(Pageable pageable, String searchName);
    Page<Product> findAllByNameAndCategory_Id(Pageable pageable, String searchName, int categoryId);
}

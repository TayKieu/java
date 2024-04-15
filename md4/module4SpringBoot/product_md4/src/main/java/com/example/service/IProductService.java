package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    Page<Product> findByName(Pageable pageable, String searchName);
    List<Product> findAllNotPaging();

    void save(Product product);

    void delete(int id);

    ProductDto findProductById(int id);

    void updateProduct(ProductDto productDto);

    Page<Product> findAllFields(Pageable pageable, String searchName, int categoryId);
}

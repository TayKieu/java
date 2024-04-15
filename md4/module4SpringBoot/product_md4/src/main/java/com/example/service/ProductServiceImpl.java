package com.example.service;

import com.example.dto.ProductDto;
import com.example.model.Category;
import com.example.model.Product;
import com.example.repo.IProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepo productRepo;
    @Override
    public Page<Product> findByName(Pageable pageable,String searchName) {
        return productRepo.findAllByNameContaining(pageable,searchName);
    }
    @Override
    public Page<Product> findAllFields(Pageable pageable, String searchName, int categoryId) {
        return productRepo.findAllByNameAndCategory_Id(pageable, searchName, categoryId);
    }
    @Override
    public List<Product> findAllNotPaging() {
        return productRepo.findAll();
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(int id) {
        productRepo.deleteById(id);
    }

    @Override
    public ProductDto findProductById(int id) {
        Product product = productRepo.findById(id).get();
        return mapToProductDto(product);
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = mapToProduct(productDto);
        productRepo.save(product);
    }



    private ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product,productDto);
        return productDto;
    }
    private Product mapToProduct(ProductDto productDto) {
        Product product = new Product();
        BeanUtils.copyProperties(productDto,product);
        return product;
    }
}

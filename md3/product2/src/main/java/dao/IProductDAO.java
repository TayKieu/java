package dao;

import model.Category;
import model.Product;

import java.util.List;

public interface IProductDAO {
 List<Product> selectAllProduct();
 Product insertProduct(Product product);
boolean delete(int id);
 List<Product> findProduct(String name);
 boolean updateProduct(Product product);
 Product selectById(int id);
}

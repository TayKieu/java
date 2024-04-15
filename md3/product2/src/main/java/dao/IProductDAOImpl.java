package dao;

import model.Category;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IProductDAOImpl implements IProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/product_management";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    private static final String SELECT_ALL_PRODUCT = "select * from product p join category c on p.categoryId = c.id order by p.id";

    @Override
    public List<Product> selectAllProduct() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id =rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String quantity = rs.getString("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                int categoryId = rs.getInt("categoryId");
                String categoryName = rs.getString(9);
                productList.add(new Product(id,name,price,quantity,color,description,categoryId, categoryName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    private static final String INSERT_PRODUCT = "insert into product (name,price,quantity,color,description,categoryId) values (?,?,?,?,?,?)";
    @Override
    public Product insertProduct(Product product) {
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(INSERT_PRODUCT);){
            statement.setString(1,product.getName());
            statement.setString(2,product.getPrice());
            statement.setString(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategoryId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    private static final String DELETE_PRODUCT ="delete from product where id = ?";
    @Override
    public boolean delete(int id) {
        boolean rowDelete;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT)){
            statement.setInt(1,id);
            rowDelete = statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDelete;
    }

    private static  final String SELECT_PRODUCT_BY_NAME = "select * from product p join category c on p.categoryId = c.id where p.name like concat('%',?,'%');";
    @Override
    public List<Product> findProduct(String name) {
        List<Product> productList = new ArrayList<>();
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME);) {
            statement.setString(1,name);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int id = rs.getInt(1);
                String name1 = rs.getString(2);
                String price = rs.getString(3);
                String quantity = rs.getString(4);
                String color = rs.getString(5);
                String description = rs.getString(6);
                String categoryName = rs.getString(7);
                productList.add(new Product(id,name1,price,quantity,color,description,categoryName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    private static  final String UPDATE_PRODUCT = "update product  set name = ?, price = ?, quantity = ?, color = ?, description = ?, categoryId = ? where id = ?;";
    @Override
    public boolean updateProduct(Product product) {
        boolean rowUpdate;
        try(Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);){
            statement.setString(1,product.getName());
            statement.setString(2,product.getPrice());
            statement.setString(3,product.getQuantity());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getDescription());
            statement.setInt(6,product.getCategoryId());
            statement.setInt(7, product.getId());
            rowUpdate = statement.executeUpdate()>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  rowUpdate;
    }

    private static  final String SELECT_PRODUCT_BY_ID = "select * from product where id = ?";
    @Override
    public Product selectById(int id) {
        Product product = null;
        try(Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)){
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String name = rs.getString(2);
                String price = rs.getString(3);
                String quantity = rs.getString(4);
                String color = rs.getString(5);
                String description = rs.getString(6);
                Integer categoryId = rs.getInt(7);
                product = new Product(id, name, price, quantity, color, description, categoryId);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

}

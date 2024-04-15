package com.example.model.dao;

import com.example.model.bean.User;

import java.sql.*;

public class FindUserDAO {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/pdf2word";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "12345";

    protected static Connection getConnection() {
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

    private static final String FIND_USER_BY_NAME = "select * from user where username = ?";
    public static User GetUser(String username){
        User user = new User();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_NAME);
            statement.setString(1,username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                int userId = rs.getInt("user_id");
                String password = rs.getString("password");
                String fullName = rs.getString("fullname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                user = new User(userId,username,password,fullName,email,phone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

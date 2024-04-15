package com.example.model.dao;

import java.sql.*;

public class UploadFileDAO {
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

    private static final String UPDATE_NEW_FILE = "insert into fileupload(user_id,file_name,status) values(?,?,?)";
    private static final String UPLOAD_FILE ="update fileupload set status = ? where file_name = ?" ;
    public static void Upload(String fileName,int userId,int status){
        try{
            Connection connection = getConnection();
            if(!IsFileExist(fileName)){
                PreparedStatement statement = connection.prepareStatement(UPDATE_NEW_FILE);
                statement.setInt(1,userId);
                statement.setString(2,fileName);
                statement.setInt(3,status);
                statement.executeUpdate();
            }
            else {
                PreparedStatement statement = connection.prepareStatement(UPLOAD_FILE);
                statement.setInt(1,status);
                statement.setString(2,fileName);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String FIND_FILE_BY_NAME = "select * from fileupload where file_name = ?";
    private static boolean IsFileExist(String fileName) {
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_FILE_BY_NAME);
            statement.setString(1,fileName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()){
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

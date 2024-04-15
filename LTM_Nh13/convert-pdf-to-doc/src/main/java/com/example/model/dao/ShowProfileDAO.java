package com.example.model.dao;

import com.example.model.bean.FileUpload;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowProfileDAO {
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

    private static final String FIND_USER_BY_ID = "select * from fileupload where user_id = ?";
    public static List<FileUpload> GetProcessedFile (int userId){
        List<FileUpload> files = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setInt(1,userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int fileId = rs.getInt("file_id");
                String fileName = rs.getString("file_name").split("\\.")[0] + ".docx";
                if(fileName.length() > 20){
                    fileName = fileName.substring(0,20) + "...docx";
                }
                int status = rs.getInt("status");

                files.add(new FileUpload(fileId,userId,fileName,status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
    public static List<FileUpload> GetPdfFiles (int userId){
        List<FileUpload> files = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_USER_BY_ID);
            statement.setInt(1,userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int fileId = rs.getInt("file_id");
                String fileName = rs.getString("file_name");
                int status = rs.getInt("status");

                files.add(new FileUpload(fileId,userId,fileName,status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}

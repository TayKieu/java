package com.example.model.dao;

import com.example.model.bean.FileUpload;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListFilePdfDAO {
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
    private static final String LIST_FILE_UPLOAD = "Select * from fileupload";
    public static List<FileUpload> getAllFileUpLoad(){
        List<FileUpload> files = new ArrayList<>();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(LIST_FILE_UPLOAD);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int fileId = rs.getInt("file_id");
                String fileName = rs.getString("file_name");
                int status = rs.getInt("status");
                files.add(new FileUpload(fileId,fileName,status));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
}

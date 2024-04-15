package com.example.model.dao;

import com.example.CONSTAINT.Constaint;
import com.example.model.bean.FileUpload;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConvertFileDAO {
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

    private static final String GET_CONVERT_FILE = "select * from fileupload where user_id = ? and status = " + Constaint.PROCESSING;
    public static List<FileUpload> GetListConvertFile(Integer id){
        List<FileUpload> files = new ArrayList<>();
        try{Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_CONVERT_FILE);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                int fileId = rs.getInt("file_id");
                int userId = rs.getInt("user_id");
                String fileName = rs.getString("file_name");
                int fileStatus = rs.getInt("status");
                files.add(new FileUpload(fileId,userId,fileName,fileStatus));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return files;
    }

    private static final String CHANGE_STATUS = "UPDATE fileupload set status = ? where file_id = ?";
    public static void ChangeStatus(Integer fileStatus, Integer fileId){
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(CHANGE_STATUS);
            statement.setInt(1,fileStatus);
            statement.setInt(2,fileId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

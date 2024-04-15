package com.example.model.dao;

import com.example.model.bean.FileUpload;

import java.sql.*;

public class DownloadFileDAO {
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

    private static final String FIND_FILE_BY_ID = "select * from fileupload where file_id = ?";
    public static FileUpload GetFile(int fileId){
        FileUpload file = new FileUpload();
        try{
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(FIND_FILE_BY_ID);
            statement.setInt(1,fileId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                int userId = rs.getInt("user_id");
                String fileName = rs.getString("file_name").split("\\.")[0] + ".docx";
                int status = 2;
                 file = new FileUpload(fileId,userId,fileName,status);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return file;
    }

}

package com.example.model.bo;

import com.example.CONSTAINT.Constaint;
import com.example.model.bean.User;
import com.example.model.dao.UploadFileDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class UploadFileBO implements Runnable{
    HttpServletRequest request;
    User user;

    public UploadFileBO(HttpServletRequest request, User user) {
        this.request = request;
        this.user = user;
    }
    @Override
    public void run() {
        try {
            for (Part part : request.getParts()) {
                if (part.getName().equals("files_upload")) {
                    String filename = extractFileName(part);
                    filename = new File(filename).getName();

                    try {
                        File file = new File(getFolderUpload(), filename);
                        Files.copy(part.getInputStream(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        UploadFileDAO.Upload(filename, user.getUserId(), Constaint.PROCESSING);
                    } catch (Exception e) {
                        UploadFileDAO.Upload(filename, user.getUserId(), Constaint.UPLOAD_ERROR);
                    }
                }
            }
        } catch (Exception e) {

        }
        new ConvertFileBO(user).run();
    }
    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private File getFolderUpload() {
        File folderUpload = new File(System.getProperty("user.home") + "/pdfs");
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}

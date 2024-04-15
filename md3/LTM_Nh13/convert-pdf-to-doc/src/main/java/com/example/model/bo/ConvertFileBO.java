package com.example.model.bo;

import com.example.CONSTAINT.Constaint;
import com.example.model.bean.FileUpload;
import com.example.model.bean.User;
import com.example.model.dao.ConvertFileDAO;
import com.spire.pdf.FileFormat;
import com.spire.pdf.PdfDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ConvertFileBO implements Runnable {
    User user;

    public ConvertFileBO(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        List<FileUpload> files = ConvertFileDAO.GetListConvertFile(user.getUserId());
        for (FileUpload file : files) {
            String fileName = file.getFileName().split("\\.")[0];
            try {
                Convert(fileName);
                ConvertFileDAO.ChangeStatus(Constaint.SUCCESS,file.getFileId());
            } catch (Exception e) {
                ConvertFileDAO.ChangeStatus(Constaint.CONVERT_ERROR,file.getFileId());
            }
        }
    }

    private void Convert(String filename) throws Exception {
        PdfDocument pdf = new PdfDocument();
        pdf.loadFromFile(GetFolderPath("pdfs").getAbsolutePath() + File.separator + filename + ".pdf");
        pdf.saveToFile(GetFolderPath("docxs").getAbsolutePath() + File.separator + filename + ".docx", FileFormat.DOCX);
        pdf.close();
    }

    private File GetFolderPath(String folder) {
        File folderUpload = new File(System.getProperty("user.home") + "/" + folder);
        if (!folderUpload.exists()) {
            folderUpload.mkdirs();
        }
        return folderUpload;
    }
}

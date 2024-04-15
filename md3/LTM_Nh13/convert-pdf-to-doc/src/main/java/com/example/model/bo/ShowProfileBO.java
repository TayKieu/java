package com.example.model.bo;

import com.example.model.bean.FileUpload;
import com.example.model.dao.ShowProfileDAO;

import java.util.List;

public class ShowProfileBO {
public static List<FileUpload> GetProcessFile(int userId){return ShowProfileDAO.GetProcessedFile(userId);}
public static List<FileUpload> GetPdfFiles(int userId){return ShowProfileDAO.GetPdfFiles(userId);}

}

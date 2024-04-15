package com.example.model.bo;

import com.example.model.bean.FileUpload;
import com.example.model.dao.DownloadFileDAO;

public class DownloadFileBO {
    public static FileUpload GetFile(int fileId) {
        return DownloadFileDAO.GetFile(fileId);
    }
}

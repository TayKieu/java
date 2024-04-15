package com.example.model.bo;

import com.example.model.bean.FileUpload;
import com.example.model.dao.ListFilePdfDAO;

import java.util.List;

public class ListFilePdfBO {
    public static List<FileUpload> findAllFiles(){
        return ListFilePdfDAO.getAllFileUpLoad();
    }
}

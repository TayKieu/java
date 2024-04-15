package com.example.model.bo;

import com.example.model.dao.CheckLoginDAO;

public class CheckLoginBO {
    public static boolean CheckLogin(String username, String password) {
        return CheckLoginDAO.CheckLogin(username, password);
    }
}

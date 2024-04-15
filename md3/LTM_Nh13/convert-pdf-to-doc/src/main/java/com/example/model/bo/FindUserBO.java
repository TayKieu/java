package com.example.model.bo;

import com.example.model.bean.User;
import com.example.model.dao.FindUserDAO;

public class FindUserBO {
    public static User FindUser(String username) {
        return FindUserDAO.GetUser(username);
    }
}

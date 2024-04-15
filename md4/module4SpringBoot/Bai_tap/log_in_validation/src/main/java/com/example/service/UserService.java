package com.example.service;

import com.example.model.User;
import com.example.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo iUserRepo;
    @Override
    public boolean save(User user) {
       User newUser = iUserRepo.save(user);
       if(newUser != null){
           return true;
       }
       return false;
    }
}

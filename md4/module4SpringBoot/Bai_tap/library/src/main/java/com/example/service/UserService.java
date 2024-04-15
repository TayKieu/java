package com.example.service;

import com.example.model.User;
import com.example.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public boolean save(User user) {
        User newUser = userRepo.save(user);
        if(newUser != null){
            return true;
        }
        return false;
    }
}

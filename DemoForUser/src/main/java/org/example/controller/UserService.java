package org.example.controller;

import org.example.Pojo.User;
import org.example.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userMapper;

    public int deleteUserById(int id) {
        return userMapper.deleteUser(id);
    }

    public void createUser(User user) {
        userMapper.insertUser(user);
    }
}
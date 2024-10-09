package org.example.Util;

import org.apache.ibatis.annotations.Mapper;
import org.example.Pojo.User;
import org.example.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserUtils {

    @Autowired
    private UserDao userDao;


    public int deleteUserById(int id) {
        return userDao.deleteUser(id);
    }

    public void createUser(User user) {
        userDao.insertUser(user);
    }
}
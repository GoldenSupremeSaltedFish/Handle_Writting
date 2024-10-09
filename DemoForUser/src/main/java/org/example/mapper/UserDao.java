package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;

import org.example.Pojo.User;
import org.springframework.stereotype.Repository;


public interface UserDao {

     int insertUser(User user);
     int updateUser(User user);
     int deleteUser(int id);
}
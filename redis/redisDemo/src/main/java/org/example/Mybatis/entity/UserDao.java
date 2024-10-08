package org.example.Mybatis.entity;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements org.example.Mybatis.mapper.UserDao {
    private Integer id;
    private String name;
    private String password;
    public UserDao(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    @Override
    public int insertUser(UserDao userDao) {
        return 0;
    }

    @Override
    public int updateUser(UserDao userDao) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}

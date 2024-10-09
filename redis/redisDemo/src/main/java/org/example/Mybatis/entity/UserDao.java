package org.example.Mybatis.entity;

import org.example.POJO.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements org.example.Mybatis.mapper.UserDao {
    private Integer id;
    private String name;
    private String password;
    public UserDao() {}

    @Override
    public int insertUser(User user) {
        return 0;
    }

    @Override
    public int updateUser(User user) {
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        return 0;
    }
}

package org.example.Mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    public int insertUser(org.example.Mybatis.entity.UserDao userDao);
    public int updateUser(org.example.Mybatis.entity.UserDao userDao);
    public int deleteUser(int id);
}

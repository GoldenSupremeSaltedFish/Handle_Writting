package org.example.Mybatis.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.example.POJO.User;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDao {

    public int insertUser(User user);
    public int updateUser(User user);
    public int deleteUser(int id);
}

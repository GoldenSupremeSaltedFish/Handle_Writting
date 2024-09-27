package Mybatis.mapper;

import Mybatis.entity.User;

public interface UserDao {

    public int insertUser(User user);

    public int deleteUser(int id);

    public int updateUser(User user);

    public User selectUser(int id);

    public int countUser();

    public User checkLogin(String username, String password);

    public int checkUsername(String username);

    public int checkEmail(String email);

    public int checkPhone(String phone);
}



import org.example.Config.StarterConfig;
import org.example.Mybatis.entity.UserDao;
import org.example.POJO.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = StarterConfig.class)
public class mybatisTester {



    UserDao userDao=new UserDao();
    @Test
    public void testInsertUser() {
        User user = new User();
        userDao.insertUser(user);

    }

    @Test
    public void testUpdateUser() {

        User user = new User();
        userDao.updateUser(user);

    }

    @Test
    public void testDeleteUser() {
        User user = new User();
        userDao.deleteUser(11);

    }
}

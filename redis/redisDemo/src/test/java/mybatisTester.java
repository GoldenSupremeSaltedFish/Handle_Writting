

import org.example.Config.StarterConfig;
import org.example.Mybatis.entity.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = StarterConfig.class)
public class mybatisTester {

//    @Autowired
//    private Mybatis.mapper.UserDao userDao;

    @Test
    public void testInsertUser() {
        UserDao userDao = new UserDao(1, "TestUser", "password123");
        userDao.insertUser(userDao);

    }

    @Test
    public void testUpdateUser() {
        UserDao userDao = new UserDao(2, "TestUser", "password123");


        userDao.updateUser(userDao);

    }

    @Test
    public void testDeleteUser() {
        UserDao userDao = new UserDao(2, "TestUser", "password123");
        userDao.deleteUser(1);

    }
}

package org.example;

import org.example.Mybatis.entity.UserDao;
import org.example.POJO.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
@SpringBootApplication

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
    SpringApplication.run(ApplicationContext.class, args);// 运行 Spring 应用程序
        User user=new User(11,"11","11");
        UserDao userDao=new UserDao();
        userDao.insertUser(user);

    }
}
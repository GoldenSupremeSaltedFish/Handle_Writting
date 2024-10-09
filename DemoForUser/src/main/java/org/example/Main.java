
package org.example;

//import
import org.example.Pojo.User;
import org.example.controller.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@MapperScan("org.example.mapper")
//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args); // 运行 Spring 应用程序
        User user = new User(1, "张三", "123456");
        UserService userService = new UserService(); // 从 Spring 容器中获取 UserService
        userService.createUser(user);
    }
}

package org.example.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class User {

    private Integer id;
    private String name;
    private String password;
    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

package org.example.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor

public class User {

    private Integer id;
    @Getter
    private String name;
    @Getter
    private String password;
    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public int getId() {
        return id;
    }
}
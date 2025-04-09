package com.example.suny.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data//更加综合，生成get和set
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//id使用自增的方式进行生成
    private Integer userId;
    private String userName;
    private Integer userAge;

}

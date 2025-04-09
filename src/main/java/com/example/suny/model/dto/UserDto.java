package com.example.suny.model.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class UserDto {

    @NotBlank(message = "用户id不能为空")
    private Integer userId;
    @NotBlank(message = "用户名字不能为空")
    private String userName;
    @NotBlank(message = "用户年龄不能为空")
    private Integer userAge;

}


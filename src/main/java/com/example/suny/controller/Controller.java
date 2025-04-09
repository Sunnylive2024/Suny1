package com.example.suny.controller;

import com.example.suny.handler.ResponseMessage;
import com.example.suny.model.User;
import com.example.suny.model.dto.UserDto;
import com.example.suny.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class Controller {
    @Autowired
    IUserService userService;


    @PostMapping("/manage/adduser")
    public ResponseMessage addUser(@Validated @RequestBody UserDto user) {
        User userNew = userService.addUser(user);
        return ResponseMessage.success(userNew);
    }

    @GetMapping("/search/ById")
    public ResponseMessage getUserById(@PathVariable Integer userId) {
        User userNew = userService.getUserById(userId);
        return ResponseMessage.success(userNew);

    }

    @PutMapping("/manage/editUser")
    public ResponseMessage editUser(@Validated @RequestBody UserDto user) {
        User userNew = userService.editUser(user);
        return ResponseMessage.success(userNew);
    }

    @DeleteMapping("/manage/delete")
    public ResponseMessage deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return ResponseMessage.success(null);
    }

    @GetMapping("/list/agegreaterthan")
    public List<User> userAgeGreaterThan(@RequestParam Integer userAge) {
        return userService.userAgeGreaterThan(userAge);
    }

    @GetMapping("/list/uniquenames")
    public List<User> getUsersWithUniqueNames() {
        return userService.getUsersWithUniqueNames();
    }

    @GetMapping("/list/sort/age/asc")
    public List<User> getUsersSortedByAge() {
        return userService.getUsersSortedByAge();
    }

    @GetMapping("/list/sort/age/desc")
    public List<User> getUsersSortedByAgeDesc() {
        return userService.getUsersSortedByAgeDesc();
    }

    @GetMapping("/search/byname")
    public User getUsersByName(@RequestParam String name) {
        return userService.getUsersByName(name);
    }

    @GetMapping("/list/usernames")
    public List<String> getUserNames() {
        return userService.getUserNames();
    }
    @GetMapping("/list/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/list/sort/namelong/asc")
    public List<User> getUsersSortedByName() {
         return userService.getUsersSortedByNameLength();

    }
    @GetMapping("/list/sort/namelength/desc")
    public List<User> getUsersSortedByNameDesc() {
        return userService.getUsersSortedByNameLengthDesc();

    }
}


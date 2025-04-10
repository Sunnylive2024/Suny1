package com.example.suny.service;

import com.example.suny.model.User;
import com.example.suny.model.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {

    User addUser(UserDto user);

    User getUserById(Integer id);

    User editUser(UserDto user);

    void deleteUser(Integer userId);

    List<User> userAgeGreaterThan(Integer userAge);

    List<User> getUsersSortedByAge();

    List<User> getUsersSortedByAgeDesc();

    List<User> getUsersWithUniqueNames();

    List<String> getUserNames();


    User getUsersByName(String userName);

    List<User> getAllUsers();

    List<User> getUsersSortedByNameLength();

    List<User> getUsersSortedByNameLengthDesc();
}

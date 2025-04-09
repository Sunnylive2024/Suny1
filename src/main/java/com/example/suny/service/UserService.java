package com.example.suny.service;

import com.example.suny.model.User;
import com.example.suny.model.dto.UserDto;
import com.example.suny.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Override//添加用户以及更改用户信息
    public User addUser(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);//dto转pojo
        return userRepository.save(userPojo);
    }

    @Override//使用了optional抛出异常
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在");
        });

    }

    @Override//修改用户
    public User editUser(UserDto user) {
        User userPojo = new User();
        BeanUtils.copyProperties(user, userPojo);
        return userRepository.save(userPojo);

    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> userAgeGreaterThan(Integer userAge) {
        return userRepository.findByAgeGreaterThan(userAge);
    }

    @Override
    public List<User> getUsersSortedByAge() {
        return userRepository.findByOrderByUserAgeAsc();
    }
    @Override
    public List<User> getUsersSortedByAgeDesc() {
        return userRepository.findByOrderByUserAgeDesc();
    }



    @Override
    public List<User> getUsersWithUniqueNames() {
        return userRepository.findUsersWithUniqueNames();
    }

    @Override
    public List<String> getUserNames() {
        return userRepository.getUserNames();
    }

    @Override
    public User getUsersByName(String userName) {
        return userRepository.findByUserName(userName).orElseThrow(() -> {
            throw new IllegalArgumentException("用户不存在");
        });
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersSortedByNameLength() {
        return userRepository.findUsersOrderedByNameLength();
    }

    @Override
    public List<User> getUsersSortedByNameLengthDesc() {
        return userRepository.findUsersOrderedByNameLengthDesc();
    }


}

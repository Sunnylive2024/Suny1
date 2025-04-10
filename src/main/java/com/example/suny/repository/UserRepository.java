package com.example.suny.repository;


import com.example.suny.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByAgeGreaterThan(Integer userAge);//gpt不骗我的话，jpa还真是牛逼，对符合的语句可以自动转化为SQL语句

    @Query("SELECT u FROM User u WHERE u.userName IN (SELECT u2.userName FROM User u2 GROUP BY u2.userName HAVING COUNT(u2.userName) = 1)")
//jpa自定义语句
    List<User> findUsersWithUniqueNames();

    List<User> findByOrderByUserAgeAsc();

    List<User> findByOrderByUserAgeDesc();


    @Query("SELECT u.userName FROM User u")
    List<String> getUserNames();

    Optional<User> findByUserName(String userName);

    @Query("SELECT u FROM User u ORDER BY LENGTH(u.userName) ASC")
    List<User> findUsersOrderedByNameLength();

    @Query("SELECT u FROM User u ORDER BY LENGTH(u.userName) DESC")
    List<User> findUsersOrderedByNameLengthDesc();
}



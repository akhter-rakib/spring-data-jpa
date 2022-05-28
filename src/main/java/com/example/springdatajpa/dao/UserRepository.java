package com.example.springdatajpa.dao;

import com.example.springdatajpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByProfession(String profession);

    int countByAge(int age);

    List<User> deleteByName(String name);

    List<User> findByProfessionAndAge(String profession, int age);

    List<User> findByProfessionIgnoreCase(String profession);

    @Query("select u from User u")
    List<User> userCustomQueryAllList();

    @Modifying
    @Query(value = "update User u set u.name = 'Rakib Khan'  where u.name =:name")
    void updateName(String name);

}

package com.example.springdatajpa.controller;

import com.example.springdatajpa.model.User;
import com.example.springdatajpa.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get-users")
    public List<User> getAllUsers() {
        return userService.userListWithCustomSQL();
    }

    @GetMapping("/getUser-by-profession/{profession}")
    public List<User> getUserByProfession(@PathVariable String profession) {
        return userService.getUserByProfession(profession);
    }

    @GetMapping("/get-user-count/{age}")
    public String getCountByAge(@PathVariable int age) {
        long count = userService.countByAge(age);
        return "total no of records : " + count;
    }

    @DeleteMapping("/delete/{name}")
    public List<User> deleteUser(@PathVariable String name) {
        return userService.deleteUserByName(name);
    }

    @GetMapping("/find-multi-condition/{profession}/{age}")
    public List<User> getUsersByProfessionAndAge(@PathVariable String profession, @PathVariable int age) {
        return userService.getByAgeAndProfession(age, profession);
    }

    @GetMapping("/get-users-ignore-case")
    public List<User> getUsersByprofession(@RequestParam("profession") String profession) {
        return userService.getUserIgnoreCaseProfession(profession);
    }

    @GetMapping("/get-sort/{field}")
    public List<User> getSortedUsers(@PathVariable String field) {
        return userService.getUserSort(field);
    }

    @GetMapping("/get-paginated-data")
    public Page<User> getPaginatedRecords() {
        return userService.getPaginatedUser();
    }

    @GetMapping("/get-user-list-by-sorted-paginated")
    public ResponseEntity<List<User>> responseEntity(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "DESC") String sortDirection) {
        List<User> list = userService.getAllUser(pageNo, pageSize, sortBy, sortDirection);
        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/update-name/{name}")
    public void updateName(@PathVariable String name) {
        userService.updateName(name);
    }
}


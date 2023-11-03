package com.example.mongodb.controller;

import com.example.mongodb.service.UserService;
import com.example.mongodb.module.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable String id){
        return userService.findById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        userService.deleteById(id);
    }

}

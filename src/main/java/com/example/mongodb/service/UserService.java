package com.example.mongodb.service;

import com.example.mongodb.module.User;
import com.example.mongodb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public User save(User user){
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException(" %s --> Username already exists".formatted(user.getUsername()));
        }
        userRepository.save(user);
        return user;
    }
    public User findById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User not found this id %s".formatted(id))
        );
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }
    public void deleteById(String id){
        userRepository.deleteById(id);
    }
}

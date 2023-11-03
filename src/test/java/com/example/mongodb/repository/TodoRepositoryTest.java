package com.example.mongodb.repository;

import com.example.mongodb.module.Todo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class TodoRepositoryTest {
    @Autowired
    private TodoRepository todoRepository;
    private final String userId="6545030530ef8f6a41981530";

    @Test
    void findByUserId() {
        List<Todo> byUserId = todoRepository.findByUserId(userId);
        System.out.println("byUserId = " + byUserId);
        Assertions.assertFalse(byUserId.isEmpty());
    }
    @Test
    void deleteById(){
        String todoId = "654528a810706a042f28ec2e";
        todoRepository.deleteById("654528a810706a042f28ec2e");
        Assertions.assertEquals(0,  todoRepository.findAll().size());
    }
}
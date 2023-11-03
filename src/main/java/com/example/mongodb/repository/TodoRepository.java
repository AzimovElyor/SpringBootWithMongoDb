package com.example.mongodb.repository;

import com.example.mongodb.module.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TodoRepository extends MongoRepository<Todo,String> {
    List<Todo> findByUserId(String userId);

}

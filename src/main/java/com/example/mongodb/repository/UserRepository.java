package com.example.mongodb.repository;

import com.example.mongodb.module.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
  List<User> findByName(String name);
  Boolean existsByUsername(String username);
}

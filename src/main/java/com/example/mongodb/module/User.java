package com.example.mongodb.module;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Document("user")
public class User {
    @Id
    private String id;
    private String name;
    private String surname;
    @Indexed(unique = true)
    private String username;
}

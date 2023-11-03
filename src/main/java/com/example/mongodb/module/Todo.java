package com.example.mongodb.module;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "todo")
public class Todo {
    @Id
    private String id;
    private String userId;
    private String title;
    private String description;
    private Boolean completed = false;
    private LocalDateTime createdDate;

}

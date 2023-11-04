package com.example.mongodb.service;

import com.example.mongodb.module.Todo;
import com.example.mongodb.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    public Todo create(Todo todo){
        todoRepository.save(todo);
        return todo;
    }
    public List<Todo> getUserTodos(String userId){
        List<Todo> byUserId = todoRepository.findByUserId(userId);
        System.out.println("byUserId = " + byUserId);
        return byUserId;
    }
    public Todo getTodoById(String id){
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found this id %s ".formatted(id)));
    }
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }
    public void completeTodo(String todoId){
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new RuntimeException("Todo not found this id %s".formatted(todoId)));
        todo.setCompleted(true);
        todoRepository.save(todo);
    }
    public void delete(String todoId){
        todoRepository.deleteById(todoId);
    }

}

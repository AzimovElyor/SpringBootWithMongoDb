package com.example.mongodb.controller;

import com.example.mongodb.module.Todo;
import com.example.mongodb.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public Todo create(@RequestBody Todo todo){
        return todoService.create(todo);
    }
    @GetMapping("/{id}")
    public Todo getById(@PathVariable String id){
        return todoService.getTodoById(id);
    }
    @GetMapping("/all")
    public List<Todo> getAll(){
        return todoService.getAllTodos();
    }
    @GetMapping("/user-todos/{userId}")
    public List<Todo> getUserTodos(@PathVariable("userId") String id){
        return todoService.getUserTodos(id);
    }
    @PutMapping("/{id}")
    public void completeTodo(@PathVariable String id){
        todoService.completeTodo(id);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        todoService.delete(id);
    }
    @GetMapping("/title/{title}")
    public List<Todo> findbyTitle(@PathVariable String title){
        return todoService.findByTitle(title);
    }
}

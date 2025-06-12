package com.example.ch2labs.labs07.controller;

import com.example.ch2labs.labs07.dto.TodoRequestDto;
import com.example.ch2labs.labs07.model.Todo;
import com.example.ch2labs.labs07.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoRequestDto todoRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todoRequestDto));
    }

    @GetMapping
    public ResponseEntity<?> getAllTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoRequestDto todoRequestDto){
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodo(id, todoRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id){
        Todo todo = todoService.deleteTodo(id);
        if (todo == null) return ResponseEntity.status(404).body("404 Not Found");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}

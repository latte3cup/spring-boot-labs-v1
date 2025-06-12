package com.example.ch2labs.labs07.service;

import com.example.ch2labs.labs07.dto.TodoRequestDto;
import com.example.ch2labs.labs07.dto.TodoResponseDto;
import com.example.ch2labs.labs07.model.Todo;
import com.example.ch2labs.labs07.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto todoDto){
        Todo todo = todoRepository.save(new Todo(todoDto.getTitle(),todoDto.isCompleted()));
        return new TodoResponseDto(todo.getId(),todo.getTitle(),todo.isCompleted());
    }


    public List<TodoResponseDto> getAllTodos(){
        return todoRepository.findAll().stream()
                .map(todo-> new TodoResponseDto(todo.getId(),todo.getTitle(),todo.isCompleted()))
                .collect(Collectors.toList());
    }

    public TodoResponseDto updateTodo( Long id, TodoRequestDto todoDto){
        Todo todo = todoRepository.update(id, new Todo(todoDto.getTitle(),todoDto.isCompleted()));
        return new TodoResponseDto(todo.getId(),todo.getTitle(),todo.isCompleted());
    }

    public Todo deleteTodo(Long id){
        return todoRepository.delete(id);
    }
}

package com.example.ch2labs.labs07.repository;

import com.example.ch2labs.labs07.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TodoRepository {
    private final Map<Long, Todo> store = new HashMap<>();
    private Long nextId = 1L;

    public Todo save(Todo todo){
        todo.setId(nextId);
        store.put(nextId++,todo);
        return todo; // 응답에 반환
    }

    public List<Todo> findAll(){
        return new ArrayList<>(store.values());
    }

    public Todo update(Long id, Todo todo){
        todo.setId(id);
        store.put(id,todo);
        return todo;
    }

    public Todo delete(Long id){
        return store.remove(id);
    }

}

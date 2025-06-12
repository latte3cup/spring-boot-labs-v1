package com.example.ch2labs.labs07.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Todo {
    private Long id;
    private String title;
    private boolean completed;

    public Todo(String title, boolean completed) {
        this.title = title;
        this.completed = completed;
    }
}

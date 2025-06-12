package com.example.ch2labs.labs07.testInit;

import com.example.ch2labs.labs07.model.Todo;
import com.example.ch2labs.labs07.repository.TodoRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {

    private  final TodoRepository todoRepository;

    @PostConstruct
    public void init() {
        todoRepository.save(new Todo(1L,"title1",false));
        todoRepository.save(new Todo(2L,"title2",false));
        todoRepository.save(new Todo(3L,"title3",false));
        todoRepository.save(new Todo(4L,"title4",false));
    }
}

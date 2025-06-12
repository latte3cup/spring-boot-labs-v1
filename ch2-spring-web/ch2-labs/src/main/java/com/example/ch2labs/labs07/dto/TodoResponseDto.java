package com.example.ch2labs.labs07.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@AllArgsConstructor
@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private boolean completed;
}

package com.example.ch2labs.labs07.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequestDto {
    private String title;
    private boolean completed;

}

package com.example.ch4labs.Comment.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentCreateRequest {
    String content;
    String author;
}

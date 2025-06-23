package com.example.ch4labs.Comment.data;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponseDto {
    Long id;
    String content;
    String author;
    Long reviewId;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}

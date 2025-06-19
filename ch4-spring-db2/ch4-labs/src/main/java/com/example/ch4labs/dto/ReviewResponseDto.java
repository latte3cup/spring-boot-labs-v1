package com.example.ch4labs.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

}


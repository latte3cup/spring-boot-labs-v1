package com.example.ch4labs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public static ReviewResponse from(ReviewResponseDto responseDto){
        return new ReviewResponse(
                responseDto.getId(),
                responseDto.getTitle(),
                responseDto.getContent(),
                responseDto.getAuthor(),
                responseDto.getBookTitle(),
                responseDto.getBookAuthor(),
                responseDto.getRating()
        );
    }
}

package com.example.ch4labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSearchRequest {
    private String reviewAuthor;
    private String reviewTitle;
    private String reviewContent;
    private String bookTitle;
    private String bookAuthor;
    private String sort;
    private Integer rating;
    private Integer minRating;
    private Integer maxRating;
    private int page = 0;
    private int size = 10;
}



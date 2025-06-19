package com.example.ch4labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewSearchRequest {
    private String author;
    private String bookTitle;
    private double rating;
    private double minRating;
    private double maxRating;
    private int page = 0;
    private int size = 10;
}



package com.example.ch4labs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class ReviewPageResponse {
    private int page;
    private int size;
    private long totalCount;
    private int totalPages;
    private List<ReviewResponseDto> reviews;

    public static ReviewPageResponse from(List<ReviewResponseDto> posts, ReviewSearchRequest search, Long count) {
        int totalPages = (int) Math.ceil((double) count / search.getSize());

}




package com.example.ch4labs.Review.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private String bookTitle;
    private String bookAuthor;
    private int rating;

    public static ReviewResponseDto from(Review review) {
        return new ReviewResponseDto(
                review.getId(),
                review.getTitle(),
                review.getContent(),
                review.getAuthor(),
                review.getBookTitle(),
                review.getBookTitle(),
                review.getRating());
    }
}


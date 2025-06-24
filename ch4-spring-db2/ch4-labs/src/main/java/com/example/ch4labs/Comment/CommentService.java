package com.example.ch4labs.Comment;

import com.example.ch4labs.Comment.data.Comment;
import com.example.ch4labs.Comment.data.CommentCreateRequest;
import com.example.ch4labs.Comment.data.CommentResponseDto;
import com.example.ch4labs.Comment.data.CommentUpdateRequest;
import com.example.ch4labs.Review.ReviewService;
import com.example.ch4labs.Review.data.Review;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ReviewService reviewService;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponseDto createComment(Long reviewId, CommentCreateRequest request) {

        Review review =reviewService.getReviewById(reviewId);
        Comment comment = Comment.builder()
                .review(review)
                .content(request.getContent())
                .author(request.getAuthor())
                .createdAt(LocalDateTime.now())
                .build();

        Comment responseComment = commentRepository.save(comment);

        return CommentResponseDto.builder()
                .id(responseComment.getId())
                .content(responseComment.getContent())
                .author(responseComment.getAuthor())
                .reviewId(responseComment.getReview().getId())
                .createdAt(responseComment.getCreatedAt())
                .build();
    }

    @Transactional
    public CommentResponseDto updateComment(long commentId, CommentUpdateRequest request) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id " + commentId));
        comment.setContent(request.getContent());
        comment.setUpdatedAt(LocalDateTime.now());
        return CommentResponseDto.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .author(comment.getAuthor())
                .reviewId(comment.getReview().getId())
                .createdAt(comment.getCreatedAt())
                .updatedAt(comment.getUpdatedAt())
                .build();
    }
}

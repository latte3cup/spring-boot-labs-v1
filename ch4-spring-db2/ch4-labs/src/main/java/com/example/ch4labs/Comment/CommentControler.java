package com.example.ch4labs.Comment;

import com.example.ch4labs.Comment.data.Comment;
import com.example.ch4labs.Comment.data.CommentCreateRequest;
import com.example.ch4labs.Comment.data.CommentResponseDto;
import com.example.ch4labs.Comment.data.CommentUpdateRequest;
import com.example.ch4labs.Review.data.Review;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CommentControler {
    private final CommentService commentService;

    @PostMapping("/reviews/{reviewId}/comments")
    public ResponseEntity<CommentResponseDto> create(@RequestBody CommentCreateRequest request, @PathVariable long reviewId) {
        return ResponseEntity.status(201).body(commentService.createComment(reviewId, request));
    }

    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentResponseDto> update(@RequestBody CommentUpdateRequest request, @PathVariable long commentId) {
        return ResponseEntity.status(200).body((commentService.updateComment(commentId,request)));
    }
}

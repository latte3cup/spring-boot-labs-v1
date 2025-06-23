package com.example.ch4labs.Comment;


import com.example.ch4labs.Comment.data.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}

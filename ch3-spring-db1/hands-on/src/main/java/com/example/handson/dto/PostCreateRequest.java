package com.example.handson.dto;

import com.example.handson.domain.Post;
import lombok.Data;

@Data
public class PostCreateRequest {
    private String title;
    private String body;

    public Post toDomain() {
        Post post = new Post();
        post.setTitle(this.title);
        post.setBody(this.body);
        return post;
    }
}
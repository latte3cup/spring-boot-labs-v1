package com.example.handson.mapper;

import com.example.handson.domain.Post;
import com.example.handson.dto.PostSearchRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void save(Post post);
//    List<Post> findAll();
    List<Post> findAll(PostSearchRequest search);
    int count(PostSearchRequest search); // 전체 개수
    Post findById(Long id);
    int update(Post post);
    int deleteById(Long id);
}

package com.captainyun7.ch4examples.v3.service;

import com.captainyun7.ch4examples.v3.domain.Post;
import com.captainyun7.ch4examples.v3.domain.QPost;
import com.captainyun7.ch4examples.v3.dto.*;
import com.captainyun7.ch4examples.v3.repository.PostRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {

    private final PostRepository repository;
    private final JPAQueryFactory queryFactory;

    public PostResponse createPost(PostCreateRequest request) {
        Post post = request.toDomain();
        Post saved = repository.save(post);
        return PostResponse.from(saved);
    }

//    @Transactional(readOnly = true)
//    public PostPageResponse search(PostSearchRequest request) {
//        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
//        Page<PostResponse> page = repository.findByTitleContaining(request.getKeyword(), pageable)
//                .map(PostResponse::from);
//
//        return PostPageResponse.from(page.getContent(), request, page.getTotalElements());
//    }

    @Transactional(readOnly = true)
    public PostPageResponse search(PostSearchRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by("createdAt").descending());

        Page<Post> posts = null;
        // 조건 조합 분기
        if (request.getKeyword() != null && request.getAuthor() != null) {
            posts = repository.findByAuthorAndTitleContaining(request.getAuthor(), request.getKeyword(), pageable);
            // posts = repository.searchByAuthorAndTitle(request.getAuthor(), request.getKeyword(), pageable);
        } else if (request.getKeyword() != null) {
            posts = repository.findByTitleContaining(request.getKeyword(), pageable);
        } else if (request.getAuthor() != null) {
            posts = repository.findByAuthor(request.getAuthor(), pageable);
        } else if (request.getCreatedAt() != null) {
            posts = repository.findByCreatedAtAfter(request.getCreatedAt(), pageable);
            // posts = repository.searchByCreatedAfter(request.getCreatedAt(), pageable);
        } else {
            posts = repository.findAll(pageable); // 조건 없으면 전체 조회
        }

        Page<PostResponse> page = posts.map(PostResponse::from);

        return PostPageResponse.from(page.getContent(), request, page.getTotalElements());
    }

    @Transactional(readOnly = true)
    public PostResponse getPostById(Long id) {
        return repository.findById(id)
                .map(PostResponse::from)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));
    }

    public PostResponse updatePost(Long id, PostUpdateRequest request) {
        Post post = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글이 존재하지 않습니다."));
        post.setTitle(request.getTitle());
        post.setBody(request.getBody());

        return PostResponse.from(post);
    }

    public void deletePost(Long id) {
        repository.deleteById(id);
    }


    public Page<PostResponse> search(PostSearchRequest request, Pageable pageable) {
        QPost qPost = QPost.post;

        BooleanBuilder builder = new BooleanBuilder();
        if(StringUtils.hasText(request.getKeyword())) {
            builder.and(qPost.title.contains(request.getKeyword()));
        }

        ///queryFactory.selectFrom(qPost).where(???=builder)
        return null;
    }


}
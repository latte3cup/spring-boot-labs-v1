package com.example.ch4labs.Review;

import com.example.ch4labs.Review.data.QReview;
import com.example.ch4labs.Review.data.Review;
import com.example.ch4labs.Review.data.ReviewResponseDto;
import com.example.ch4labs.Review.data.ReviewSearchRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.PathBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewQueryRepository {

    private final JPAQueryFactory queryFactory;

    public Page<ReviewResponseDto> searchReviews(ReviewSearchRequest request) {
        QReview review = QReview.review;
        BooleanBuilder builder = new BooleanBuilder();
        PathBuilder<Review> pathBuilder = new PathBuilder<>(Review.class, "review");

        // 조건 빌드
        if (request.getBookTitle() != null && !request.getBookTitle().isBlank()) {
            builder.and(review.bookTitle.containsIgnoreCase(request.getBookTitle()));
        }
        if (request.getBookAuthor() != null && !request.getBookAuthor().isBlank()) {
            builder.and(review.bookAuthor.containsIgnoreCase(request.getBookAuthor()));
        }
        if (request.getRating() != null) {
            builder.and(review.rating.eq(request.getRating()));
        }
        if (request.getMinRating() != null) {
            builder.and(review.rating.goe(request.getMinRating()));
        }
        if (request.getMaxRating() != null) {
            builder.and(review.rating.loe(request.getMaxRating()));
        }
        if (request.getReviewContent() != null && !request.getReviewContent().isBlank()) {
            builder.and(review.title.containsIgnoreCase(request.getReviewContent()));
        }
        if (request.getReviewTitle() != null && !request.getReviewTitle().isBlank()) {
            builder.and(review.author.containsIgnoreCase(request.getReviewTitle()));
        }
        if (request.getReviewAuthor() != null && !request.getReviewAuthor().isBlank()) {
            builder.and(review.author.containsIgnoreCase(request.getReviewAuthor()));
        }


        // 정렬 처리
        OrderSpecifier<?> order = null;
        if (request.getSort() != null && !request.getSort().isBlank()) {
            String[] sortOption = request.getSort().split(",");
            if (sortOption.length == 2) {
                order = "asc".equalsIgnoreCase(sortOption[1])
                        ? pathBuilder.getString(sortOption[0]).asc()
                        : pathBuilder.getString(sortOption[0]).desc();
            }
        }

        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

        // 데이터 조회 쿼리
        var query = queryFactory.selectFrom(review)
                .where(builder);

        if (order != null) {
            query = query.orderBy(order);
        } else {
            query = query.orderBy(review.id.desc()); // 기본 정렬
        }

        // 전체 개수 조회
        long total = query.fetchCount();

        // 페이징 적용
        List<Review> reviews = query.offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        List<ReviewResponseDto> content = reviews.stream()
                .map(ReviewResponseDto::from)
                .toList();

        return new PageImpl<>(content, pageable, total);
    }


}

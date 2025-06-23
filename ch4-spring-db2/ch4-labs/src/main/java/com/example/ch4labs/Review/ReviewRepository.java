package com.example.ch4labs.Review;

import com.example.ch4labs.Review.data.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findByTitle(String title, Pageable pageable);

    Page<Review> findByAuthorAndRatingGreaterThanEqual(String author, Double rating, Pageable pageable);

    Page<Review> findByRatingBetween(Double minRating, Double maxRating, Pageable pageable);

    Page<Review> findByAuthorContainingAndTitleContainingOrContentContainingAndRatingGreaterThanEqual(
            String author, String titleKeyword, String contentKeyword, int minRating, Pageable pageable);

}
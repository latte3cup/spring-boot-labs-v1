package com.example.ch4labs;

import com.example.ch4labs.dto.Review;
import com.example.ch4labs.dto.ReviewResponseDto;
import com.example.ch4labs.dto.ReviewSearchRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;
    private final ReviewQueryRepository reviewQueryRepository;

    @Autowired
    public ReviewService(ReviewRepository repository, ReviewQueryRepository reviewQueryRepository) {
        this.repository = repository;
        this.reviewQueryRepository = reviewQueryRepository;
    }

    public Review create(Review review) {
        return repository.save(review);
    }

    public List<Review> findAll() {
        return repository.findAll();
    }

    public Review update(Long id, Review updated) {
        return repository.findById(id).map(r -> {
            r.setTitle(updated.getTitle());
            r.setContent(updated.getContent());
            r.setAuthor(updated.getAuthor());
            r.setBookTitle(updated.getBookTitle());
            r.setBookAuthor(updated.getBookAuthor());
            r.setRating(updated.getRating());
            return repository.save(r);
        }).orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Page<ReviewResponseDto> search(ReviewSearchRequest request) {
        return reviewQueryRepository.searchReviews(request);
    }


}

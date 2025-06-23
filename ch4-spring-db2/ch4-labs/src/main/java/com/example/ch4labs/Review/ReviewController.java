package com.example.ch4labs.Review;

import com.example.ch4labs.Review.data.Review;
import com.example.ch4labs.Review.data.ReviewResponseDto;
import com.example.ch4labs.Review.data.ReviewSearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    // Create
    @PostMapping
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return ResponseEntity.status(201).body(service.create(review));
    }

    // Read all
    @GetMapping
    public List<Review> findAll() {
        return service.findAll();
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Review> update(@PathVariable Long id, @RequestBody Review review) {
        return ResponseEntity.ok(service.update(id, review));
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public Page<ReviewResponseDto> searchReviews(@ModelAttribute ReviewSearchRequest request) {
        return  service.search(request);
    }
}

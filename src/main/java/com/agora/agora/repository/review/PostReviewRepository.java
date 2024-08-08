package com.agora.agora.repository.review;

import com.agora.agora.domain.entity.review.PostReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostReviewRepository extends JpaRepository<PostReview, Long> {
}


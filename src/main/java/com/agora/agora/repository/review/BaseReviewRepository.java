package com.agora.agora.repository.review;

import com.agora.agora.domain.entity.review.BaseReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseReviewRepository extends JpaRepository<BaseReview, Long> {
    
}

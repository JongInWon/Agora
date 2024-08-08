package com.agora.agora.repository.review;

import com.agora.agora.domain.entity.review.OneLineReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OneLineReviewRepository extends JpaRepository<OneLineReview, Long> {
    
    @Query("select olr from OneLineReview olr where olr.baseReviewId = :baseReviewId")
    OneLineReview findOneByBaseReviewId(@Param("baseReviewId") Long baseReviewId);
}

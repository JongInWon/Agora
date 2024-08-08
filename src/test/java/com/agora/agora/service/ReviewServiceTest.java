package com.agora.agora.service;

import com.agora.agora.controller.review.request.OneLineReviewCreateRequest;
import com.agora.agora.domain.entity.review.BaseReview;
import com.agora.agora.domain.entity.review.OneLineReview;
import com.agora.agora.domain.entity.review.ReviewType;
import com.agora.agora.repository.review.BaseReviewRepository;
import com.agora.agora.repository.review.OneLineReviewRepository;
import com.agora.agora.repository.review.PostReviewRepository;
import com.agora.agora.service.review.ReviewService;
import com.agora.agora.service.review.request.OneLineReviewCreateServiceRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@Transactional
@SpringBootTest
class ReviewServiceTest {
    @Autowired
    ReviewService reviewService;
    @Autowired
    BaseReviewRepository baseReviewRepository;
    @Autowired
    OneLineReviewRepository oneLineReviewRepository;
    @Autowired
    PostReviewRepository postReviewRepository;

    @DisplayName("한 줄 평 하나를 저장한다.")
    @Test
    void test() {
        // given
        OneLineReviewCreateRequest build = OneLineReviewCreateRequest.builder()
                .isbn("12341234123")
                .type(ReviewType.ONE_LINE)
                .description("한 줄 평입니다.")
                .build();
        OneLineReviewCreateServiceRequest serviceRequest = build.toServiceRequest(1L);

        // when
        reviewService.saveOneLineReview(serviceRequest);
        List<BaseReview> baseReviews = baseReviewRepository.findAll();
        List<OneLineReview> oneLineReviews = oneLineReviewRepository.findAll();


        // then
        assertThat(baseReviews).hasSize(1);
        assertThat(oneLineReviews).hasSize(1);
    }
}
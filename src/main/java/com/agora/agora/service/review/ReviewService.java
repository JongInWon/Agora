package com.agora.agora.service.review;

import com.agora.agora.domain.entity.review.BaseReview;
import com.agora.agora.domain.entity.review.OneLineReview;
import com.agora.agora.repository.review.BaseReviewRepository;
import com.agora.agora.repository.review.OneLineReviewRepository;
import com.agora.agora.service.review.request.OneLineReviewCreateServiceRequest;
import com.agora.agora.service.review.response.OneLineReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final BaseReviewRepository baseReviewRepository;
    private final OneLineReviewRepository oneLineReviewRepository;

    @Transactional
    public OneLineReviewResponse saveOneLineReview(OneLineReviewCreateServiceRequest request) {
        BaseReview baseReview = BaseReview.builder()
                .userId(request.getUserId())
                .isbn(request.getIsbn())
                .type(request.getType())
                .build();
        BaseReview savedBaseReview = baseReviewRepository.save(baseReview);

        OneLineReview oneLineReview = OneLineReview.builder()
                .baseReviewId(savedBaseReview.getId())
                .description(request.getDescription())
                .build();
        OneLineReview savedOneLineReview = oneLineReviewRepository.save(oneLineReview);

        return OneLineReviewResponse.of(savedBaseReview, savedOneLineReview);
    }
}

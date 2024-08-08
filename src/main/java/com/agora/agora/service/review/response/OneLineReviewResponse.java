package com.agora.agora.service.review.response;

import com.agora.agora.domain.entity.review.BaseReview;
import com.agora.agora.domain.entity.review.OneLineReview;
import com.agora.agora.domain.entity.review.ReviewType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OneLineReviewResponse {

    private Long userId;
    private String description;
    private String isbn;
    private ReviewType type;

    public static OneLineReviewResponse of(BaseReview baseReview, OneLineReview oneLineReview) {
        return OneLineReviewResponse.builder()
                .userId(baseReview.getUserId())
                .isbn(baseReview.getIsbn())
                .type(baseReview.getType())
                .description(oneLineReview.getDescription())
                .build();
    }
}

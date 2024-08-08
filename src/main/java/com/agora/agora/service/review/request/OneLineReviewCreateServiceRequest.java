package com.agora.agora.service.review.request;

import com.agora.agora.domain.entity.review.ReviewType;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OneLineReviewCreateServiceRequest {

    private Long userId;
    private String description;
    private String isbn;
    private ReviewType type;
}

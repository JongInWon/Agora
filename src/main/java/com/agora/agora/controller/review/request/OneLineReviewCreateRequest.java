package com.agora.agora.controller.review.request;

import com.agora.agora.domain.entity.review.ReviewType;
import com.agora.agora.service.review.request.OneLineReviewCreateServiceRequest;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OneLineReviewCreateRequest {

    @NotEmpty(message = "내용 입력은 필수입니다.")
    private String description;
    private String isbn;
    private ReviewType type;

    public OneLineReviewCreateServiceRequest toServiceRequest(Long userId) {
        return OneLineReviewCreateServiceRequest.builder()
                .userId(userId)
                .description(description)
                .isbn(isbn)
                .type(type)
                .build();
    }
}

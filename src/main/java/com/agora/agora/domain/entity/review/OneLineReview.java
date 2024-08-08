package com.agora.agora.domain.entity.review;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "one_line_reviews")
@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OneLineReview {

    @Id
    @GeneratedValue
    @Column(name = "one_line_review_id")
    private Long id;

    @NotBlank
    private String description;

    @NotNull
    @Column(name = "base_review_id")
    private Long baseReviewId;
}

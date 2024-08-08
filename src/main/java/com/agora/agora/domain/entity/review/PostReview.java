package com.agora.agora.domain.entity.review;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "post_reviews")
@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostReview {

    @Id()
    @GeneratedValue
    @Column(name = "post_review_id")
    private Long id;

    private String title;
    private String description;
    @Column(name = "base_review_id")
    private Long baseReviewId;
}

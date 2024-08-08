package com.agora.agora.domain.entity.review;

import com.agora.agora.domain.BaseTimeEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name = "base_reviews")
@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BaseReview extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "base_review_id")
    private Long id;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    private String isbn;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReviewType type;
}

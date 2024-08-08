package com.agora.agora.repository.review;

import com.agora.agora.domain.entity.review.BaseReview;
import com.agora.agora.domain.entity.review.OneLineReview;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static com.agora.agora.domain.entity.review.ReviewType.ONE_LINE;
import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest
class OneLineReviewRepositoryTest {

    @Autowired
    private BaseReviewRepository baseReviewRepository;

    @Autowired
    private OneLineReviewRepository oneLineReviewRepository;

    private BaseReview savedBaseReview;

    @BeforeEach
    void setUp() {
        BaseReview baseReview = BaseReview.builder()
                .type(ONE_LINE)
                .userId(1L)
                .isbn("1234123412341")
                .build();
        savedBaseReview = baseReviewRepository.save(baseReview);
    }

    @DisplayName("한 줄 평 리뷰를 하나 저장한다.")
    @Test
    void saveOneLineReview() {
        // given
        OneLineReview oneLineReview = createOneLineReview(savedBaseReview.getId());

        // when
        OneLineReview savedOneLineReview = oneLineReviewRepository.save(oneLineReview);

        // then
        assertThat(savedOneLineReview.getId()).isNotNull();
        assertThat(savedOneLineReview.getBaseReviewId()).isEqualTo(savedBaseReview.getId());
        assertThat(savedOneLineReview)
                .extracting("description", "baseReviewId")
                .containsExactly("본문입니다.", savedBaseReview.getId());
    }

    @DisplayName("baseReviewId로 한 줄 평 리뷰를 조회한다.")
    @Test
    void findOneLineReviewsByBaseReviewId() {
        // given
        OneLineReview oneLineReview = createOneLineReview(savedBaseReview.getId());
        oneLineReviewRepository.save(oneLineReview);

        // when
        OneLineReview findOneLineReview = oneLineReviewRepository.findOneByBaseReviewId(savedBaseReview.getId());

        // then
        assertThat(findOneLineReview.getBaseReviewId()).isEqualTo(savedBaseReview.getId());
    }

    private OneLineReview createOneLineReview(Long baseReviewId) {
        return OneLineReview.builder()
                .description("본문입니다.")
                .baseReviewId(baseReviewId)
                .build();
    }
}
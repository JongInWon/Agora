package com.agora.agora.controller.review;

import com.agora.agora.controller.review.request.OneLineReviewCreateRequest;
import com.agora.agora.domain.dto.UserDto;
import com.agora.agora.repository.UserRepository;
import com.agora.agora.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReviewController {

    private final UserRepository userRepository;
    private final ReviewService reviewService;

    @PostMapping("/review/{isbn}")
    public String saveOneLineReview(@ModelAttribute OneLineReviewCreateRequest request, @AuthenticationPrincipal UserDto userDto) {
        reviewService.saveOneLineReview(request.toServiceRequest(userDto.getId()));
        return "redirect:/detail/isbn/{isbn}";
    }
}

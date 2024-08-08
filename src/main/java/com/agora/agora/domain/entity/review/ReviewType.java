package com.agora.agora.domain.entity.review;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReviewType {

    POST("포스팅 후기"),
    ONE_LINE("한 줄 평"),
    ;

    private final String text;
}

package com.agora.agora.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Meta {
    private boolean isEnd;
    private int pageableCount;
    private int totalCount;
}
package com.agora.agora.domain.dto.book;

import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchDto {

    private List<DocumentsDto> documents;
    private MetaDto meta;
}

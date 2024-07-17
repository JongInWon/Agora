package com.agora.agora.domain.dto.book;

import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchDto {

    private List<DocumentsDto> documents;
    private MetaDto meta;
    private static ModelMapper modelMapper = new ModelMapper();
}

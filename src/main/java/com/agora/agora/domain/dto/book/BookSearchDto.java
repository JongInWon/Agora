package com.agora.agora.domain.dto.book;

import lombok.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;

import java.util.List;
import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSearchDto {
    
    private List<BookDto> documents;
    private MetaDto meta;
    private static ModelMapper modelMapper = new ModelMapper();

    public BookSearchDto createBookSearchDto() {
        modelMapper.getConfiguration()
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setFieldMatchingEnabled(true);
        return modelMapper.map(this, BookSearchDto.class);
    }

    public static BookSearchDto of(Map<String, Object> item) {
        return modelMapper.map(item, BookSearchDto.class);
    }
}

package com.agora.agora.domain.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.Meta;

import java.util.List;

@Data
@NoArgsConstructor
public class BookSearchDto {
    private List<BookDto> documents;
    private Meta meta;
}

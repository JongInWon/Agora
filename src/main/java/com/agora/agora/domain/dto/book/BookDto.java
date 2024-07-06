package com.agora.agora.domain.dto.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookDto {
    private List<String> authors;
    private List<String> translators;
    private String title;
    private String contents;
    private String datetime;
    private String isbn;
    private String publisher;
    private String thumbnail;
    private String url;
}
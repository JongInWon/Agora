package com.agora.agora.domain.dto.book;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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
package com.agora.agora.domain.dto;

import lombok.Data;

@Data
public class BookDto {
    private String title;
    private String authors;
    private String contents;
    private String thumbnail;
    private String isbn;
}

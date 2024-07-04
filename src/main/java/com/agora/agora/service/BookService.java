package com.agora.agora.service;

import com.agora.agora.config.WebClientFactory;
import com.agora.agora.domain.dto.BookSearchResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final WebClientFactory kakaoBookRepository;

    public BookSearchResponse getBooksData(String query) {
        Map<String, Object> books = kakaoBookRepository.WebClient().searchBooks(query);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(books, BookSearchResponse.class);
    }
}

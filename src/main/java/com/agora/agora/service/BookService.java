package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.repository.KakaoBookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final KakaoBookRepository kakaoBookRepository;

    public BookSearchDto getBooksDataByTarget(String query, String target) throws JsonProcessingException {
        String books = kakaoBookRepository.searchBooks(query, target);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(books, BookSearchDto.class);
    }
}

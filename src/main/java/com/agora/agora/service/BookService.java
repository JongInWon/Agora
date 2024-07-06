package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.repository.KakaoBookRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final KakaoBookRepository kakaoBookRepository;
    private final ModelMapper modelMapper;

    public BookSearchDto getBooksData(String query) {
        Map<String, Object> books = kakaoBookRepository.searchBooks(query);
        return modelMapper.map(books, BookSearchDto.class);
    }
}

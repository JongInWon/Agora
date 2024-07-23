package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.domain.dto.book.DocumentsDto;
import com.agora.agora.exception.JsonParsingException;
import com.agora.agora.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository bookRepository;
    private final ObjectMapper objectMapper;

    public BookSearchDto getBookDetailsWithQueryByTarget(String query, String target) {
        String jsonResponse = bookRepository.findAllWithQueryByTarget(query, target);
        BookSearchDto bookSearchDto = parseJsonToDto(jsonResponse, BookSearchDto.class);
        return modifyIsbn(bookSearchDto);
    }

    private <T> T parseJsonToDto(String json, Class<T> dto) {
        try {
            return objectMapper.readValue(json, dto);
        } catch (JsonProcessingException e) {
            throw new JsonParsingException("Error parsing JSON response", e);
        }
    }

    private BookSearchDto modifyIsbn(BookSearchDto bookSearchDto) {
        bookSearchDto.getDocuments().forEach(DocumentsDto::changeToIsbn13);
        return bookSearchDto;
    }
}

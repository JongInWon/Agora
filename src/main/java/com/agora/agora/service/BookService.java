package com.agora.agora.service;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.domain.dto.book.DocumentsDto;
import com.agora.agora.exception.JsonParsingException;
import com.agora.agora.repository.BookRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
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

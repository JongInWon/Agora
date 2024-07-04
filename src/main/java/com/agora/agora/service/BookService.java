package com.agora.agora.service;

import com.agora.agora.config.WebClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BookService {

    private final WebClientFactory kakaoBookRepository;

    public Map getBooksData(String query) {
        return kakaoBookRepository.WebClient().searchBooks(query);
    }
}

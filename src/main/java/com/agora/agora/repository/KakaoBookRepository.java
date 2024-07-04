package com.agora.agora.repository;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.Map;

@Component
@HttpExchange
public interface KakaoBookRepository {

    @GetExchange("/v3/search/book")
    Map getBooksData(@RequestParam("query") String query);
}
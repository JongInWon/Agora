package com.agora.agora.repository;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface KakaoBookRepository {

    @GetExchange("/v3/search/book")
    String searchBooks(@RequestParam("query") String query, @RequestParam("target") String target);
}



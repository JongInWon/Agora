package com.agora.agora.repository;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface BookRepository {

    @GetExchange("/v3/search/book")
    String findAllWithQueryByTarget(@RequestParam("query") String query, @RequestParam("target") String target);
}



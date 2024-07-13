package com.agora.agora.controller;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public String getBookDataByTitle(@RequestParam("query") String query, @RequestParam("target") String target, Model model) throws JsonProcessingException {
        BookSearchDto booksDataByTarget = bookService.getBooksDataByTarget(query, target);
        model.addAttribute("books", booksDataByTarget.getDocuments());
        return "booksSearch";
    }
}


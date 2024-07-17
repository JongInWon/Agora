package com.agora.agora.controller;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.domain.dto.book.DocumentsDto;
import com.agora.agora.service.BookService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    @GetMapping("/detail/{target}/{isbn}")
    public String getBookDetail(@PathVariable("isbn") String isbn, @PathVariable("target") String target, Model model) throws JsonProcessingException {
        BookSearchDto bookDetails = bookService.getBooksDataByTarget(isbn, target);
        List<DocumentsDto> documents = bookDetails.getDocuments();
        model.addAttribute("documents", documents);
        return "bookDetail";
    }
}


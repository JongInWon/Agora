package com.agora.agora.controller;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public String getData(@RequestParam("query") String query, Model model) {
        BookSearchDto booksData = bookService.getBooksData(query);
        model.addAttribute("books", booksData.getDocuments());
        return "booksSearch";
    }
}

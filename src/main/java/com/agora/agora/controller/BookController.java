package com.agora.agora.controller;

import com.agora.agora.domain.dto.book.BookSearchDto;
import com.agora.agora.domain.dto.book.DocumentsDto;
import com.agora.agora.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/search")
    public String getBookDetailsWithQueryByTarget(@RequestParam("query") String query, @RequestParam("target") String target, Model model) {
        BookSearchDto bookDetails = bookService.getBookDetailsWithQueryByTarget(query, target);
        List<DocumentsDto> documents = bookDetails.getDocuments();
        model.addAttribute("documents", documents);
        return "bookList";
    }

    @GetMapping("/detail/{target}/{isbn}")
    public String getBookDetailsPage(@PathVariable("isbn") String isbn, @PathVariable("target") String target, Model model) {
        BookSearchDto bookDetails = bookService.getBookDetailsWithQueryByTarget(isbn, target);
        List<DocumentsDto> documents = bookDetails.getDocuments();
        model.addAttribute("documents", documents);
        return "bookDetail";
    }
}


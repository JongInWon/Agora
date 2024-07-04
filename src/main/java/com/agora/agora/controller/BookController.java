package com.agora.agora.controller;

import com.agora.agora.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/data")
    public String getData(@RequestParam("query") String query, Model model) {
        Map books = bookService.getBooksData(query);
        model.addAttribute("books", books);
        return "kakao";
    }
}

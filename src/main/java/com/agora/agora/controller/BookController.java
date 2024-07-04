package com.agora.agora.controller;

import com.agora.agora.config.WebClientFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class BookController {


    private final WebClientFactory webClientFactory;

    @GetMapping("/data")
    public String getData(@RequestParam("query") String query, Model model) {
        Map books = webClientFactory.WebClient().getBooksData(query);
        model.addAttribute("books", books);
        return "kakao";
    }
}

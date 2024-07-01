package com.agora.agora.controller;

import com.agora.agora.domain.dto.AccountDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("accountDto", new AccountDto());
        return "login/signup";
    }

    @PostMapping("/logout")
    public String logout() {
        return "login/signup";
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }
}



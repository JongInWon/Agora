package com.agora.agora.controller;

import com.agora.agora.domain.dto.AccountDto;
import com.agora.agora.domain.entity.Account;
import com.agora.agora.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute("accountDto") AccountDto accountDto, BindingResult bindingResult) {
        if (userService.checkDuplicateUsername(accountDto.getUsername())) {
            bindingResult.addError(new FieldError("accountDto", "username", "중복된 아이디입니다."));
            return "login/signup";
        }

        System.out.println("accountDto.getPassword() = " + accountDto.getPassword());

        Account account = Account.builder()
                .username(accountDto.getUsername())
                .password(passwordEncoder.encode(accountDto.getPassword()))
                .roles(accountDto.getRoles())
                .build();

        userService.createUser(account);
        return "redirect:/";
    }
}

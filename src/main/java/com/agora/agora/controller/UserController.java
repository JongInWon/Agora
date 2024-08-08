package com.agora.agora.controller;

import com.agora.agora.domain.dto.UserDto;
import com.agora.agora.domain.entity.User;
import com.agora.agora.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@ModelAttribute("accountDto") UserDto userDto, BindingResult bindingResult) {
        if (userService.checkDuplicateUsername(userDto.getUsername())) {
            bindingResult.addError(new FieldError("userDto", "username", "중복된 아이디입니다."));
            return "login/signup";
        }
        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .roles(userDto.getRoles())
                .build();
        userService.createUser(user);
        return "redirect:/";
    }
}

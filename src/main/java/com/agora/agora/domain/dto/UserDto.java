package com.agora.agora.domain.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String roles;
}

package com.agora.agora.domain.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountDto {

    private Long id;
    private String username;
    private String password;
    private String roles;
    private int age;
}

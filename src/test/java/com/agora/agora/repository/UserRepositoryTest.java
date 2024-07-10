package com.agora.agora.repository;

import com.agora.agora.domain.entity.Account;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @DisplayName("회원가입한 사용자를 회원 레파지토리에서 아이디로 찾는다.")
    @Test
    void createUser() {
        // given
        Account user = Account.builder()
                .username("qwer")
                .password("123456")
                .build();

        // when
        userRepository.save(user);

        // then
        assertThat(userRepository.existsByUsername("qwer")).isTrue();
    }

    @DisplayName("회원 레파지토리에서 중복된 아이디가 있는지 검사한다.")
    @Test
    void duplicateUsername() {
        // given
        Account user = Account.builder()
                .username("qwer")
                .password("123456")
                .build();

        // when
        userRepository.save(user);

        // then
        assertThat(userRepository.existsByUsername("qwer")).isTrue();
    }
}
package com.agora.agora.service;

import com.agora.agora.domain.entity.Account;
import com.agora.agora.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(Account account) {
        userRepository.save(account);
    }

    public boolean checkDuplicateUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}

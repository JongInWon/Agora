package com.agora.agora.service;

import com.agora.agora.domain.entity.User;
import com.agora.agora.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void createUser(User account) {
        userRepository.save(account);
    }

    public boolean checkDuplicateUsername(String username) {
        return userRepository.existsByUsername(username);
    }
}

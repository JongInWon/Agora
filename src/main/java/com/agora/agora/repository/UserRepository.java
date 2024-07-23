package com.agora.agora.repository;

import com.agora.agora.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, Long> {
    
    Account findByUsername(String username);

    boolean existsByUsername(String username);
}

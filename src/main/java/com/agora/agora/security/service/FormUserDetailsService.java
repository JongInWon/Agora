package com.agora.agora.security.service;

import com.agora.agora.domain.dto.AccountContext;
import com.agora.agora.domain.dto.AccountDto;
import com.agora.agora.domain.entity.Account;
import com.agora.agora.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service("UserDetailsService")
public class FormUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(account.getRoles()));
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);

        return new AccountContext(accountDto, authorities);
    }
}

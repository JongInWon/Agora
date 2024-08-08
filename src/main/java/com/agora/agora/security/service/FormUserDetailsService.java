package com.agora.agora.security.service;

import com.agora.agora.domain.dto.UserContext;
import com.agora.agora.domain.dto.UserDto;
import com.agora.agora.domain.entity.User;
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
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(user.getRoles()));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return new UserContext(userDto, authorities);
    }
}

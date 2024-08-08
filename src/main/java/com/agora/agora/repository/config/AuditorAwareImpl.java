package com.agora.agora.repository.config;

import com.agora.agora.domain.dto.UserContext;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@NonNullApi
public class AuditorAwareImpl implements AuditorAware<Long> {

    @Override
    public Optional<Long> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();

        if (principal instanceof UserContext) {
            return Optional.of(((UserContext) principal).getUserDto().getId());
        }

        return Optional.empty();
    }
}
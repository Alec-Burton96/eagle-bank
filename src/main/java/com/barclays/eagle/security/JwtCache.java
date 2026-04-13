package com.barclays.eagle.security;


import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Data
public class JwtCache {

    private List<JwtCacheEntry> jwtCacheEntries = new ArrayList<>();

    public record JwtCacheEntry(String token, String userId){}

    public static String getAuthTokenForRequest() {
        return Objects.requireNonNull(Objects.requireNonNull(SecurityContextHolder.getContext().getAuthentication()).getCredentials()).toString();
    }
}

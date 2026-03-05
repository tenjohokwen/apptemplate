package com.softropic.apptemplate.security.jwt.api;

import com.softropic.apptemplate.security.exposed.exception.AuthorizationException;
import jakarta.servlet.http.HttpServletRequest;

public interface TokenValidator {
    boolean isTokenFixed(HttpServletRequest request);
    boolean hasDbRefreshTokenExpired(HttpServletRequest request);
    void ensureClientHasPreLoginId();
    void ensureClientHasPostLoginId();
    void ensureAuthTokenPresent(HttpServletRequest request) throws AuthorizationException;
}

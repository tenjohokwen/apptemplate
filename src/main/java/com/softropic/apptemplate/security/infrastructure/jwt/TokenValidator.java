package com.softropic.apptemplate.security.infrastructure.jwt;

import com.softropic.apptemplate.security.contract.exception.AuthorizationException;
import jakarta.servlet.http.HttpServletRequest;

public interface TokenValidator {
    boolean isTokenFixed(HttpServletRequest request);
    boolean hasDbRefreshTokenExpired(HttpServletRequest request);
    void ensureClientHasPreLoginId();
    void ensureClientHasPostLoginId();
    void ensureAuthTokenPresent(HttpServletRequest request) throws AuthorizationException;
}

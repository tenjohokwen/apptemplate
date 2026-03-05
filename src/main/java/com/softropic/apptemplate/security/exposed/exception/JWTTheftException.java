package com.softropic.apptemplate.security.exposed.exception;


import static com.softropic.apptemplate.security.exposed.exception.SecurityError.TOKEN_THEFT;

public class JWTTheftException extends AuthorizationException {
    public JWTTheftException(final String msg) {
        super(msg,TOKEN_THEFT);
    }
}

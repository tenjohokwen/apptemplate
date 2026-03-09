package com.softropic.apptemplate.security.contract.exception;


import static com.softropic.apptemplate.security.contract.exception.SecurityError.TOKEN_THEFT;

public class JWTTheftException extends AuthorizationException {
    public JWTTheftException(final String msg) {
        super(msg,TOKEN_THEFT);
    }
}

package com.softropic.apptemplate.security.jwt.api;


import com.softropic.apptemplate.common.exception.AppSetupException;
import com.softropic.apptemplate.security.jwt.JwtSecretProvider;
import com.softropic.apptemplate.security.secret.SecretService;
import com.softropic.apptemplate.security.secret.repository.Secret;

import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.softropic.apptemplate.security.common.util.SecurityConstants.JWT_BUS_NAME;
import static com.softropic.apptemplate.security.common.util.SecurityConstants.JWT_VERSION;


/**
 * Manages the retrieval of the secret key of the JWT from the db.
 * Provides an endpoint to put the permuted secret key in the thread local for access from JwtUtil
 * When in the ThreadLocal the key is permuted (just an extra step of caution)
 */
@Service
public class JwtSecretService {
    private final SecretService secretService;

    private volatile Secret secret;

    public JwtSecretService(SecretService secretService) {this.secretService = secretService;}


    public void addSecretToThread() {
        if(secret == null) {
            secret = Optional.ofNullable(secretService.fetchSecret(JWT_VERSION, JWT_BUS_NAME))
                                 .orElseThrow(() -> new AppSetupException("JWT secret key has not been set in DB"));
        }
        JwtSecretProvider.setSecret(secret);
    }

    public void removeSecretFromThread() {
        JwtSecretProvider.removeFromThread();
    }

}

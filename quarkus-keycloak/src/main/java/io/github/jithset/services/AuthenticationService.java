package io.github.jithset.services;

import io.github.jithset.security.AuthenticationServiceClient;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {

    private final AuthenticationServiceClient authServiceClient;

    public AuthenticationService(AuthenticationServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    public String authenticate(String username, String password) {
        String token = this.authServiceClient.createAccessToken(username, password);
        return token;
    }
}

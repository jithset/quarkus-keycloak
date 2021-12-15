package io.github.jithset.security;

import io.github.jithset.config.AuthServerProperties;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationServiceClient {

    private final AuthServerProperties config;

    public AuthenticationServiceClient(AuthServerProperties config) {
        this.config = config;
    }

    public String createAccessToken(String username, String password) {
        Keycloak kc = KeycloakBuilder.builder().serverUrl(config.keycloak().serverAddress())
                .realm(config.keycloak().realm()).grantType(OAuth2Constants.PASSWORD)
                .clientId(config.keycloak().publicClientId()).username(username).password(password)
                .build();
        return kc.tokenManager().getAccessTokenString();
    }


}

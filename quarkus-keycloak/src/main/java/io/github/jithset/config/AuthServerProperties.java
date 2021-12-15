package io.github.jithset.config;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "authserver")
public interface AuthServerProperties {
    String SNLA_ID_ATTR = "snla_userid";

    Keycloak keycloak();

    interface Keycloak {
        String serverAddress();

        String realm();

        String clientId();

        String clientSecret();

        String publicClientId();
    }
}

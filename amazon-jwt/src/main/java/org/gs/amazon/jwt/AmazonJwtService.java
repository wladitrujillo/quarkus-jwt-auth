package org.gs.amazon.jwt;

import io.smallrye.jwt.build.Jwt;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class AmazonJwtService {

    public String generateJwt() {

        Set<String> groups = new HashSet<>(
                Arrays.asList("admin", "writer")
        );
        return Jwt.issuer("amazon-jwt")
                .subject("amazon-jwt")
                .groups(groups)
                .expiresAt(
                        System.currentTimeMillis() + 3600
                )
                .sign();
    }
}

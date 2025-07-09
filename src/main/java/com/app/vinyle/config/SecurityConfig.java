package com.app.vinyle.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

import java.util.List;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
    @Value("${app.jwt.test-token}")
    private String hardcodedToken;

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange -> exchange
                        .pathMatchers("/public/**").permitAll()
                        .anyExchange().authenticated()
                )
                .addFilterAt(tokenAuthenticationFilter(), SecurityWebFiltersOrder.AUTHENTICATION)
                .build();
    }

    public WebFilter tokenAuthenticationFilter() {
        return (exchange, chain) -> {
            var request = exchange.getRequest();
            var headers = request.getHeaders();
            var authHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);
                if (token.equals(hardcodedToken)) {
                    var auth = new UsernamePasswordAuthenticationToken("testUser", null, List.of());
                    var authentication = new SecurityContextImpl(auth);
                    return chain.filter(exchange).contextWrite(
                            ReactiveSecurityContextHolder.withSecurityContext(Mono.just(authentication))
                    );
                }
            }
            return chain.filter(exchange);
        };
    }

}

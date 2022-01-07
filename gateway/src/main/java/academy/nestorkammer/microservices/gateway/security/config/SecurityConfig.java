package academy.nestorkammer.microservices.gateway.security.config;

import academy.nestorkammer.microservices.core.property.JwtConfiguration;
import academy.nestorkammer.microservices.gateway.security.filter.GatewayJwtTokenAuthorizationFilter;
import academy.nestorkammer.microservices.token.security.config.SecurityTokenConfig;
import academy.nestorkammer.microservices.token.security.converter.TokenConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends SecurityTokenConfig {
    private final TokenConverter tokenConverter;

    public SecurityConfig(JwtConfiguration jwtConfiguration, TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAfter(new GatewayJwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
        super.configure(http);
    }
}

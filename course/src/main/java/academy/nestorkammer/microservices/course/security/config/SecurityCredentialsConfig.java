package academy.nestorkammer.microservices.course.security.config;

import academy.nestorkammer.microservices.core.property.JwtConfiguration;
import academy.nestorkammer.microservices.token.security.config.SecurityTokenConfig;
import academy.nestorkammer.microservices.token.security.converter.TokenConverter;
import academy.nestorkammer.microservices.token.security.filter.JwtTokenAuthorizationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityCredentialsConfig extends SecurityTokenConfig {
    private final TokenConverter tokenConverter;

    public SecurityCredentialsConfig(JwtConfiguration jwtConfiguration,
                                     TokenConverter tokenConverter) {
        super(jwtConfiguration);
        this.tokenConverter = tokenConverter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new JwtTokenAuthorizationFilter(jwtConfiguration, tokenConverter), UsernamePasswordAuthenticationFilter.class);
                super.configure(http);
    }
}

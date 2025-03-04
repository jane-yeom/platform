/*
package com.acc_platform.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@ConditionalOnProperty(name = "app.disable-security", havingValue = "true")
public class NoSecurityConfig {

    @Bean
    public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception{
        //모든 요청을 허용하고 CSRF 비활성화합니다.
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.anyRequest().permitAll())
                .httpBasic(Customizer.withDefaults());
        return http.build();

    }
}
*/

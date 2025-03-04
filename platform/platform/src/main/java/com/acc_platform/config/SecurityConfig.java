/*
package com.acc_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                //정적 리소스와 로그인, 구인 공고 등록 페이지는 인증 없이 접근 허용
                        .requestMatchers("/","job_post.html","/css/**","/js/**","/images/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable());

            return http.build();

    }
}
*/

package com.acc_platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(authorize -> authorize
              // GET 요청은 모두 허용 (글 조회)
              .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
              // 정적 리소스와 로그인, 회원가입 페이지는 모두 허용
              .requestMatchers("/css/**", "/js/**", "/images/**", "/login.html", "/sign_up.html", "/index.html").permitAll()
              // POST, PUT, DELETE 등은 인증 필요 (글 등록/수정/삭제 등)
              .requestMatchers(HttpMethod.POST, "/api/posts/**", "/api/community/**", "/api/profiles/**").authenticated()
              .requestMatchers(HttpMethod.PUT, "/api/posts/**", "/api/community/**", "/api/profiles/**").authenticated()
              .requestMatchers(HttpMethod.DELETE, "/api/posts/**", "/api/community/**", "/api/profiles/**").authenticated()
              // 그 외 요청은 기본적으로 허용
              .anyRequest().permitAll()
          )
          .formLogin(form -> form
              .loginPage("/login.html")
              .defaultSuccessUrl("/index.html", true)
              .permitAll()
          )
          .logout(logout -> logout
              .logoutUrl("/api/auth/logout")
              .logoutSuccessUrl("/index.html")
          );

        return http.build();
    }
}

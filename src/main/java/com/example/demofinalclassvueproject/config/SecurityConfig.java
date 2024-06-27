package com.example.demofinalclassvueproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable() // 禁用CSRF保护
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/register", "/login").permitAll() // 允许所有人访问注册和登录端点
                        .requestMatchers("/user/getUserPic").permitAll()
                        .requestMatchers("/bookinfo/upload","/bookinfo/search","/bookinfo/books","/bookinfo/delete/**").permitAll()
                        .requestMatchers("/updata/updatePassword").permitAll()
                        .requestMatchers("/adminuser/login","/adminuser/register").permitAll()
                        .requestMatchers("/usertoppic").permitAll()
//                        .requestMatchers("/bookinfo/search").permitAll()
                        .anyRequest().authenticated() // 其他请求需要身份验证
                )
                .httpBasic(); // 使用基本认证

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

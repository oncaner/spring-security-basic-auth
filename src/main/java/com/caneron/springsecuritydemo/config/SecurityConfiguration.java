package com.caneron.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.httpBasic()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/dashboard").hasAnyRole("admin", "user")
                .requestMatchers("/admin").hasRole("admin")
                .requestMatchers("/index").permitAll()
                .and()
                .formLogin();

        return http.build();
    }

    // InMemoryAuthentication
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails admin = User.withUsername("admin").password("{noop}123").roles("admin").build();
        UserDetails user = User.withUsername("user").password("{noop}123").roles("user").build();

        List<UserDetails> userDetails = new ArrayList<>();
        userDetails.add(admin);
        userDetails.add(user);

        return new InMemoryUserDetailsManager(userDetails);

    }
}

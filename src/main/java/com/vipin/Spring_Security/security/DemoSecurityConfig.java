package com.vipin.Spring_Security.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails vipin = User.builder()
                .username("vipin")
                .password("{noop}vipin")
                .roles("Employee")
                .build();

        UserDetails ankita = User.builder()
                .username("ankita")
                .password("{noop}ankita")
                .roles("Employee","Manager")
                .build();

        UserDetails shruti = User.builder()
                .username("shruti")
                .password("{noop}shruti")
                .roles("Employee","Manager","Admin")
                .build();

        return new InMemoryUserDetailsManager(vipin,ankita,shruti);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                        )
                .logout(logout -> logout.permitAll()
                );
        return http.build();
    }
}

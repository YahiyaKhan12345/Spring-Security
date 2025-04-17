package com.dailycodebuffer.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(
      request -> request.anyRequest().authenticated()
                )

                .httpBasic(Customizer.withDefaults());


        return httpSecurity.build();




    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails yahiya
                = User.withUsername("yahiya")
                .password("{noop}password")
                .roles("USER")
                .build();

        UserDetails nikhil
                = User.withUsername("nikhil")
                .password("{noop}nikhil")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(yahiya,nikhil);
    }

}

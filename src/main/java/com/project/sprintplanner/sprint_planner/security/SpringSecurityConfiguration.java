package com.project.sprintplanner.sprint_planner.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {

        UserDetails userDetails1 = createNewUser("ram","hanuman");
        UserDetails userDetails2 = createNewUser("radha","krishna");

        return new InMemoryUserDetailsManager(userDetails1,userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String,String> passwordEnc =
                    input -> passwordEncoderMethod().encode(input);
        UserDetails userDetails =
                User.builder()
                        .passwordEncoder(passwordEnc)
                        .username(username)
                        .password(password)
                        .roles("USER","ADMIN")
                        .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoderMethod()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception {
        // Ensure that all URLs are protected
        // Coz we are configuring the security filter chain, we would need to reconfigure this.
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.formLogin(withDefaults());
        http.csrf(csrf -> csrf.disable());
//         OR
//        http.csrf(AbstractHttpConfigurer::disable);
        http.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }


}

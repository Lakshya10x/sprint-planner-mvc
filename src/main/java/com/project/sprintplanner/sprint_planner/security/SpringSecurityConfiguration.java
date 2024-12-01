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

    /**
        This class would contains configuration of a number of spring bean
        We'll create a number of spring bean and return them back.

        NOTE - Whenever we would want to store username and password -> We would make use of ( LDAP or Database)
            Simple words -> "In-Memory Configured"

     InMemoryUserDetailsManager ->> public InMemoryUserDetailsManager(UserDetails... users)
     Where UserDetails is an Interface, so you cannot directly create instance of user details
     ** Use a builder (User class which can be used to build it)
        Create a UserDetails object and we would build an InMemoryUserDetailsManager class and return it back.
     */
//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager()
//    {
//        /**
//            This method withDefaultPasswordEncoder() from the type User is "deprecated"
//            So typically should not be used, coz "ALL PASSWORD SHOULD IDEALLY BE ENCODED !!"
//         */
//
//
//        UserDetails userDetails =
//                User.withDefaultPasswordEncoder()
//                        .username("ram")
//                        .password("hanuman")
//                        .roles("USER","ADMIN")
//                        .build();
//
//        return new InMemoryUserDetailsManager(userDetails);
//    }

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
        /**
            Implementation of PasswordEncoder that uses the Bcrypt Strong hashing function.
            Now, Spring Security starts using this PasswordEncoder
            Hence, when configuring UserDetails, also we need to make use of that specific algorithm(PasswordEncoder) which Spring Security used to encoding the password that we provided to logged in.
         */
        return new BCryptPasswordEncoder();
    }

    /**
     Configuring spring security to get H2 console working :-
     Spring Security -> Whenever you go to any URL it's redirecting to the form.
     By Default ->
     1. All URls are protected
     2. A Login form is shown for unauthorized request

     For accessing H2 Console :
     1. Disable CSRF (Cross-site request forgery)
     2. H2 also use Frames & spring security by default doesn't allow frames -> Ensure frames are allowed : By disable frame-option

     Interface - SecurityFilterChain -> defines a filter chain matched against every request,
     which is capable of being matched against a HttpServletRequest() in order to decide whether it applies to that request.

     authorizeHttpRequest -> allows restricting access based on "HttpServletRequest" using "requestMatcher" implementation

     formLogin -> Enable form login, Use all defaults that are associated with form login
     */

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

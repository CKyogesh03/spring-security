package com.security.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//springboot 3.0.x + (spring boot internally uses) spring Security 6.0.x
//this configuration is for springboot 3.0.0 + (spring boot internally uses) spring Security 6.0.0
//<version>3.0.0</version>

public class SecurityConfig3$0 { //remove this when using this class and use below class

}

/*


//@Configuration
//@EnableWebSecurity
public class SecurityConfig3$0 {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests().requestMatchers("/hii").authenticated();
        httpSecurity.authorizeHttpRequests().requestMatchers("/bye").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers("/hello").denyAll();

        httpSecurity.formLogin();
        httpSecurity.httpBasic();
        return httpSecurity.build();
    }


    @Bean
    public InMemoryUserDetailsManager setUpUsers(){

        UserDetails yogeshUser=
                User.withUsername("yogesh")
                        .password("p123")
                        .roles("admin","user")
                        .build();
        UserDetails karthiUser=
                User.withUsername("karthi")
                        .password("p150")
                        .roles("user","visitor")
                        .build();

        return new InMemoryUserDetailsManager(yogeshUser,karthiUser);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}

 */
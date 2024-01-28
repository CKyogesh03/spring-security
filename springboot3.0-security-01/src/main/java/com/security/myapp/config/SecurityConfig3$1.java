package com.security.myapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//springboot 3.1.x + (spring boot internally uses) spring Security 6.1.x
//this configuration is for springboot 3.1.2 + (spring boot internally uses) spring Security 6.1.5
//<version>3.1.8</version> , change the version in pom.xml file.
//note: dont change the <modelVersion>

@Configuration
@EnableWebSecurity
public class SecurityConfig3$1 {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(customizer->{
           customizer.requestMatchers("/hii").authenticated();
           customizer.requestMatchers("/bye").permitAll();
           customizer.requestMatchers("/hello").denyAll();
        });
        httpSecurity.formLogin(Customizer.withDefaults()); //no-args formLogin() marked for derecation in future 7.0 version
        httpSecurity.httpBasic(Customizer.withDefaults()); //no-args httpBasic() marked for derecated in future 7.0 version
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

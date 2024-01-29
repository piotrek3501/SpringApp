package com.example.rezerwacjabiletow.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import java.util.logging.ErrorManager;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebMvcConfigurerImpl{


    @Bean
    @Profile(ProfileNames.USERS_IN_MEMORY)
    public UserDetailsService userDetailsService(
            PasswordEncoder passwordEncoder) {

        var manager = new InMemoryUserDetailsManager();
        User.UserBuilder userBuilder = User.builder();

        var user = userBuilder
                .username("username")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();

        manager.createUser(user);

        return manager;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,HandlerMappingIntrospector introspector) throws Exception {


        var mvcMatcherBuilder = new MvcRequestMatcher.Builder(introspector);


        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(
                                mvcMatcherBuilder.pattern("/resources/static"),
                                mvcMatcherBuilder.pattern("/signup"),
                                mvcMatcherBuilder.pattern("/flightList"),
                                mvcMatcherBuilder.pattern("/index**"),
                                mvcMatcherBuilder.pattern("/resources/**")

                        ).permitAll()
                        .requestMatchers(
                                mvcMatcherBuilder.pattern("/admin/**")
                        ).hasRole("ADMIN")
                        .requestMatchers(
                                mvcMatcherBuilder.pattern("/db/**")
                        ).access(new WebExpressionAuthorizationManager("hasRole('ADMIN') and hasRole('DBA')"))
                        .anyRequest()
                        .authenticated()
                        );

        http.
                formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                );

        http.exceptionHandling((config)-> config.accessDeniedPage("/url_error403"));

        http
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

       /// http.logout((logout) -> logout.permitAll());
        http.csrf(config -> config.disable());

        return http.build();

    }


}


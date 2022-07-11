package com.example.pet_shelter.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    public SecurityConfig (DataSource dataSource) {this.dataSource = dataSource; }

    @Override
    protected void configure (AuthenticationManagerBuilder aut) throws Exception {
        aut.inMemoryAuthentication()
                .withUser("dmitry")
                .password ("{noop}viking")
                .authorities("ROLE_USER")
                .and()
                .withUser("bill")
                .password("{noop}booster")
                .authorities("ROLE_ADMIN");

    }
}

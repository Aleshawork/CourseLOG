package com.example.SpringSecurity.config;

import com.example.SpringSecurity.security.AuthenticationProviderService;
import com.example.SpringSecurity.security.MyUserDetailService;
import com.example.SpringSecurity.security.filter.AuthenticationLogFilter;
import com.example.SpringSecurity.security.filter.RequestValidationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationProviderService authProvider;


    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder, MyUserDetailService myUserDetailService, AuthenticationProviderService authProvider) {
        this.passwordEncoder = passwordEncoder;
        this.authProvider = authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthenticationLogFilter(),BasicAuthenticationFilter.class)
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/users/**").hasAnyRole("ADMIN")
                .antMatchers("/api/courses/**").hasAnyRole("USER","ADMIN")
                .antMatchers("/api/signup/**").permitAll()
                .anyRequest().authenticated()
        .and().httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
    }
}

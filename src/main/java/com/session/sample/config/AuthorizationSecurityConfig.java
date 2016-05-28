package com.session.sample.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.session.sample.oauth.AuthenticationEntryPoint;
import com.session.sample.oauth.AuthenticationSuccessHandler;

/**
 * Spring Web Security configuration
 */
@Configuration(value = "authorizationSecurityConfig")
@Order(-20)
public class AuthorizationSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint("/login")).and().sessionManagement().enableSessionUrlRewriting(true).and().formLogin()
        .successHandler(new AuthenticationSuccessHandler()).and().requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access").and().authorizeRequests().antMatchers("/login")
        .permitAll().anyRequest().authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.parentAuthenticationManager(authenticationManager);
  }
}

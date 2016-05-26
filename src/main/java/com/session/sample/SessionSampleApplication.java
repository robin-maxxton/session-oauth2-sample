package com.session.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.SessionAttributes;

@SpringBootApplication
@EnableResourceServer
@EnableAuthorizationServer
@EnableRedisHttpSession
@SessionAttributes("authorizationRequest")
public class SessionSampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SessionSampleApplication.class, args);
  }

}

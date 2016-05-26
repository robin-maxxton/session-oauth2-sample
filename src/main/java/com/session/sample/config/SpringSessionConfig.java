package com.session.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Hermans.r on 5/25/2016.
 */
@Configuration
public class SpringSessionConfig {

  @Bean
  protected CookieHttpSessionStrategy cookieHttpSessionStrategy(){
    CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
    strategy.setSessionAliasParamName("concern");
    return strategy;
  }

  @Bean
  public JedisConnectionFactory connectionFactory(){
    JedisConnectionFactory cf = new JedisConnectionFactory();
    cf.setHostName("localhost");
    cf.setPort(6379);
    cf.afterPropertiesSet();
    return cf;
  }

}

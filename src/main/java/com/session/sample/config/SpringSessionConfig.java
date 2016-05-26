package com.session.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.web.http.CookieHttpSessionStrategy;

/**
 * Spring Session Configuration
 */
@Configuration
public class SpringSessionConfig {

  @Bean
  protected CookieHttpSessionStrategy cookieHttpSessionStrategy() {
    CookieHttpSessionStrategy strategy = new CookieHttpSessionStrategy();
    strategy.setSessionAliasParamName("custom");
    return strategy;
  }

  @Bean
  public JedisConnectionFactory connectionFactory() {
    JedisConnectionFactory cf = new JedisConnectionFactory();
    cf.setHostName("localhost");
    cf.setPort(6379);
    cf.afterPropertiesSet();
    return cf;
  }

}

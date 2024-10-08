package org.example.Config;

import org.example.Servicre.JedisServiceImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class StarterConfig {
    @Bean
    @ConditionalOnMissingBean
    public JedisServiceImpl jedisService() {
        return new JedisServiceImpl();
    }
    @Bean
    @ConditionalOnMissingBean
    public  JedisAutoConfig jedisAutoConfig() {
        return new JedisAutoConfig();
    }
    @Bean
    @ConditionalOnMissingBean
    public JedisUtils jedisUtil() {
        return new JedisUtils();
    }
}

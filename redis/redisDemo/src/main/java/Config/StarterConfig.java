package Config;

import Servicre.JedisServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    public com.wpc.config.jedis.JedisUtils jedisUtil() {
        return new com.wpc.config.jedis.JedisUtils();
    }
}

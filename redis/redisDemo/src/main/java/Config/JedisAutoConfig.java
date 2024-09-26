package Config;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class JedisAutoConfig {
    @Bean
    public JedisPool jedisPool(RedisProperties properties) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
        poolConfig.setMinIdle(properties.getJedis().getPool().getMinIdle());
        poolConfig.setMaxTotal(properties.getJedis().getPool().getMaxActive());
//        poolConfig.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait());

        return new JedisPool(poolConfig, properties.getHost(), properties.getPort(), 2000, properties.getPassword());
    }
}

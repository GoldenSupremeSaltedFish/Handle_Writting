package org.example.Config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration

public class JedisAutoConfig {

    private static final Logger logger = LoggerFactory.getLogger(JedisAutoConfig.class);

    @Bean
    public JedisPool jedisPool(RedisProperties properties) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(properties.getJedis().getPool().getMaxIdle());
        poolConfig.setMinIdle(properties.getJedis().getPool().getMinIdle());
        poolConfig.setMaxTotal(properties.getJedis().getPool().getMaxActive());
//        poolConfig.setMaxWaitMillis(properties.getJedis().getPool().getMaxWait());

        JedisPool jedisPool = new JedisPool(poolConfig, properties.getHost(), properties.getPort(), 2000, properties.getPassword());

        // 检查连接
        try (Jedis jedis = jedisPool.getResource()) {
            jedis.ping();
            logger.info("JedisPool连接成功: " + properties.getHost() + "\t" + properties.getPort());
        } catch (Exception e) {
            logger.error("无法连接到Redis服务器: " + properties.getHost() + "\t" + properties.getPort(), e);
            throw new RuntimeException("无法连接到Redis服务器", e);
        }

        return jedisPool;
    }
}

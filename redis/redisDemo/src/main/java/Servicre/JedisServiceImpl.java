package Servicre;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import lombok.extern.slf4j.Slf4j;

@Log
@Service
public class JedisServiceImpl {

    @Autowired
    private com.wpc.config.jedis.JedisUtils jedisUtils;
    /**
     * 测试String
     * 根据key 查询value值
     */
    public String  getString(String key){
        Jedis jedis=jedisUtils.getJedis();
        String val=null;
        if(!jedis.exists(key)){
            val="南京";
            log.info(key+"在MYSQL数据库中进行查询的结果是："+val);
            jedis.set(key,val);
            log.info(key+"存入Redis中。值是："+val);

        }else{
            val=jedis.get(key);
            log.info(key+"是在Redis中查询的数据。值是："+val);
        }
        jedisUtils.close(jedis); //释放资源
        return val;
    }
    public Boolean  ishere(String key){
        Jedis jedis=jedisUtils.getJedis();

        if(!jedis.exists(key)){
            log.info("not in here");
            return false;

        }else{
            log.info(" in here");
            return true;
        }
    }
}    
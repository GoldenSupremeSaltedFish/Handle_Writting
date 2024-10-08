package org.example.Servicre;

import org.example.Config.JedisUtils;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;

@Log
@Service
public class JedisServiceImpl {

    @Autowired
    private JedisUtils jedisUtils;
    private BloomFilter<String> bloomFilter;
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
    public void  initpushFilter(String input){
        Jedis jedis=jedisUtils.getJedis();
        bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), 500000);
        bloomFilter.put(input);
        if (bloomFilter.mightContain(input)) {
            log.info("already here");
        } else {
            System.out.println("definitely not in filter");
        }
        jedis.close();
    }

    public Boolean FilterIsHere(String input){
        Jedis jedis=jedisUtils.getJedis();
        if (bloomFilter.mightContain(input)) {
            log.info("already here");
            jedis.close();
            return true;
        } else {
            System.out.println("definitely not in filter");
            jedis.close();
            return false;
        }

    }
}    
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class JedisTest {
    @Autowired
    private JedisPool jedisPool;

    @Test
    public void contextLoads() {
        System.out.println(jedisPool);
        //在连接池中得到Jedis连接
        Jedis jedis = jedisPool.getResource();
        jedis.set("haha", "你好");
        jedis.set("name", "wangpengcheng");
        //关闭当前连接
        jedis.close();

    }
}
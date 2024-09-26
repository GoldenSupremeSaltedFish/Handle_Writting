import Servicre.JedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class JedisTests {
    @Autowired(required = false)
    private JedisServiceImpl jedisService;

    @Test
    void t1() {
        String val = jedisService.getString("name");
        System.out.println(val);
    }
    @Test
    void t2() {
        boolean val = jedisService.ishere("name");
        System.out.println(val);
    }

}

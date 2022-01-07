package academy.nestorkammer.microservices.auth;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
public class AuthApplicationTests {

    @Test
    public void contextLoads() {
    }
    @Test
    public void test(){
        log.info("Enc Password '{}'", new BCryptPasswordEncoder().encode("nestor1234"));
    }

}

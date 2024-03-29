package cc.larryzeta.springboot;

import com.sun.xml.internal.ws.developer.Serialization;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigerApplicationTests {


    @Autowired
    ApplicationContext ioc;

    @Test
    public void testHelloService(){
        System.out.println(ioc.containsBean("helloService"));
    }

    @Test
    public void contextLoads() {
    }

}

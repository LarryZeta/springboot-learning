package cc.larryzeta.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

//@ImportResource(locations = {"classpath:bean.xml"})
@SpringBootApplication
public class SpringBoot02ConfigerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot02ConfigerApplication.class, args);
    }

}

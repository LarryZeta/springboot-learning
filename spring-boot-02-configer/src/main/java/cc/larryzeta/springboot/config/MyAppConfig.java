package cc.larryzeta.springboot.config;

import cc.larryzeta.springboot.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    @Bean
    public HelloService helloService(){
        System.out.println("配置类@Bean给容器添加组件了...");
        return new HelloService();
    }

}

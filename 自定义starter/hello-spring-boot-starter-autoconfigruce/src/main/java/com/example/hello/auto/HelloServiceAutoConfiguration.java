package com.example.hello.auto;

import com.example.hello.bean.HelloProperties;
import com.example.hello.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)/*默认会把这个组件放在容器中*/
public class HelloServiceAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)/*容器中没有这个组件时 才进行*/
    /* 放入HelloService组件到容器中*/
    @Bean
    public HelloService helloService(){
        HelloService helloService=new HelloService();
        return helloService;
    }
}

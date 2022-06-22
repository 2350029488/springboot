package com.example.profile.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")//当配置生产环境这个生效
     /* 当配置文件spring.profiles.active=prod时，再controller中返回类
        class com.example.profile.bean.Worker*/
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person")/*爆红不影响 因为写了两个*/
public class Worker implements Person{
    private String age;
    private String name;
}
//    @GetMapping("/")  控制类中写的
//    public String hello(){
//        return person.getClass().toString();
//    }

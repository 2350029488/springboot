package com.example.profile.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Profile("test")//当配置测试环境这个生效
     /* 当配置文件spring.profiles.active=test，在controller中返回类
        class com.example.profile.bean.Boss*/
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person")
public class Boss implements Person{
    private String age;
    private String name;
}
//    @GetMapping("/")  控制类中写的
//    public String hello(){
//        return person.getClass().toString();
//    }

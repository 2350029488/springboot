package com.springboot.boot.config;

import com.springboot.boot.pojo.Student;
import com.springboot.boot.pojo.Teacher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 、@Conditional
 * 条件装配：满足Conditional指定的条件，则进行组件注入 其有许多派生注解   注意组件的创建有先后顺序 使用时也要注意
 */

//@ConditionalOnBean(name = "student")
//注解在方类上表示容器中要有name=指定的组件才创建这个类中的组件
@Configuration(proxyBeanMethods = true)
@ImportResource(locations = "beans.xml")//导入外部资源
public class MyTwoConfig {

    @Bean
    public Student student(){
        return new Student("李四",20);
    }

    /**
     * 注意 这里有顺序 先创建student，后面的才能使用 如果把这两个方法写反也时错误的
     * @return
     */
    @ConditionalOnBean(name = "student")//注解在方法上表示容器中要有name=指定的组件才创建这个方法组件
//@ConditionalOnMissingBean(name = "student")//没有指定name=组件时创建
    @Bean
    public Teacher teacher(){
        return new Teacher("张三",student());
    }
}

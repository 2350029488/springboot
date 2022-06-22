package com.springboot.boot.config;

import com.springboot.boot.pojo.Animal;
import com.springboot.boot.pojo.Car;
import com.springboot.boot.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1.配置类中在方法上面使用@Bean注解注册组件默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods ：代理bean的方法
 * 4.@Import({User.class})
 * 给容器中自动创建出这类型的组件 默认组件的名字就是全类名com.springboot.com.springboot.boot.pojo.User
 *
 */
@Import({User.class})//在bean中是全路径名
//@Configuration()//告诉spring这是个配置文件，代替bean.xml
@Configuration(proxyBeanMethods = true)//默认为true

@EnableConfigurationProperties(Car.class)//在bean中是以前缀全路径名
//开启Car的绑定功能 ，把Car这个组件自动注册到容器中
public class MyOneConfig {

    /**
     * 外部无论对配置类中注册的方法调用多少次获取的都是之前注册容器中的单实例
     * @return
     */
    @Bean/**给容器中添加组件 默认以方法名作为组件id 返回类型就是组件类型 返回的值就是组件在容器中的实列*/
    public User user01(){
        return new User("张三",18,animal01());//为false时animal01()爆红不影响
        /*测试proxyBeanMethods = true或false 当为true时,User调用的Aniaml的方法是从容器中获取的
        *                                   当为false时，就算容器中有这个方法的组件
        *                                         也是调用的是new 的对象 两者是不相等的
        * */
    }
      @Bean("animal自定义")//自定义id
    public Animal animal01(){
        return new Animal("咖啡猫");
    }
    /**
     *     ■ 配置 类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断proxyBeanMethods = false
     *     ■ 配置类组件之间有依赖关系，方法会被调用得到之前单实例组件，用Full模式proxyBeanMethods = true
     */
}

package com.springboot.boot;


import com.springboot.boot.config.MyOneConfig;
import com.springboot.boot.pojo.Animal;
import com.springboot.boot.pojo.Car;
import com.springboot.boot.pojo.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
/**
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan(主程序所在包路径)
 * 三个等于@SpringBootApplication
 */

/**主程序类  相当于所有启动的入口
 *
 *@SpringBootApplication 这是一个springboot应用
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        /**
         * 固定配置
         */
        /*返回IOC容器*/
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        /*查看所有组件*/
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String name:beanDefinitionNames){
            System.out.println(name);
        }
        System.out.println("=====================================");
        //从容器中获取组件  并验证是单实列
        User user01 = run.getBean("user01", User.class);
        User user02 = run.getBean("user01", User.class);
        System.out.println("组件:"+(user01==user02));

        /*获取配置类*/
        MyOneConfig bean = run.getBean(MyOneConfig.class);
        System.out.println("获取配置类"+bean);
        System.out.println("=====================================");
    /* 外部无论对配置类中注册的方法调用多少次获取的都是之前注册容器中的单实例*/
        /**
         * 如果@Configuration(proxyBeanMethods = true) 表示就是代理对象调用方法
         * Springboot总会检查这个组件是否在容器中 保持组件的单实例
         * 如果为false 则每次调用都会创建新的对象
         *
         */
        Animal animal = bean.animal01();
        Animal animal1 = bean.animal01();
        System.out.println("animal:"+(animal==animal1));
        System.out.println("=====================================");

        /*测试proxyBeanMethods的状态 结论 为true则是从容器中获取的，因为注册容器中的为单实例 为false则是new的对象*/
        User user011 = run.getBean("user01", User.class);
        Animal animals = run.getBean("animal自定义", Animal.class);
        System.out.println("proxyBeanMethods的状态 user中有Animal 看是否是获取的创建对象还是从容器中获取的"
                +(user011.getAnimal()==animals)  );
        /*4.@Import({User.class})
         * 给容器中自动创建出这类型的组件 默认组件的名字就是全类名*/
        //当同一个返回类型有多个时，使用getBeanNamesForType
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("=====================================");
        for(String name:beanNamesForType){
            System.out.println(name);
        }


        System.out.println("============================");
        System.out.println("============================");
        /**测试@Conditional 的派生注解
         * */
        boolean teacher= run.containsBean("teacher");
        System.out.println(teacher);



        System.out.println("============================");
        System.out.println("============================");
        /* 测试 是否导入@ImportResource(locations = "beans.xml"导入外部资源*/
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println(hehe);
        System.out.println(haha);

        System.out.println("============================");
        System.out.println("============================");
        String[] beanNamesForType1 = run.getBeanNamesForType(Car.class);
        for (String name:beanNamesForType1){
            System.out.println(name);
        }
    }

}



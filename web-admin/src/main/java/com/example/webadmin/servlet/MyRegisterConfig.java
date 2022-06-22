package com.example.webadmin.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/*srping方式注册组件*/
@Configuration(proxyBeanMethods = true)/*必须保证组件是单实列的 因为一定是在容器中获取*/
public class MyRegisterConfig {

    /**
     * 等同于在MyServlet上注解 //@WebServlet(urlPatterns = "/my") 其MyServlet里的方法还是要写
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet(){
        MyServlet myServlet=new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my");
    }
    /**
     * 等同于在MyFilter上注解 //@WebFilter(urlPatterns = {"/css/*","/image/*"})其myFilter里的方法还是要写
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter(){
        MyFilter myFilter=new MyFilter();
//        比如这里过滤 /my
//        return new FilterRegistrationBean(myFilter,myServlet());

        //过滤  "/css/*","/image/*"
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/image/*"));
        return filterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean mylistener(){
        MyListener myListener=new MyListener();
        return new ServletListenerRegistrationBean(myListener);
    }
}

package com.example.webadmin.config;

import com.example.webadmin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**注解@EnableWebMvc 表示MVC进行全面接管，一定要慎重使用
 *  springboot自动配置的 静态资源，视图解析器，欢迎页 等全部失效
 *
 */
//@EnableWebMvc
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**@EnableWebMvc
     *                 自定义静态资源行为
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*表示访问 /xx/**所有请求都去"classpath:/static/"下面进行匹配  */
        registry.addResourceHandler("/xx/**") //类似增加前置路径 同时拦截器中还要进行放行
//                .addResourceLocations("classpath:/static/");
                .addResourceLocations("classpath:/img/");//这里修改一下，不然项目都要加上xx/的路径

         // 比如        http://localhost:8080/xx/css/bootstrap.min.css 比如
    }


    /**
     * 拦截器配置
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                                 /**拦截所有 把静态资源也会拦截*/
    registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
            //排除 "/","/login"
            /**  放行静态资源 */
            .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**","/templates/**","/xx/**","/sql");

    }

    /**
     * 设置首页方式2 在配置类中进行配置
     * @param registry
     */
//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//    }
}

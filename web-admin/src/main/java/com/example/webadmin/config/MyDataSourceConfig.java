package com.example.webadmin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;
/**
 * 现在数据源整合starter这个配置类就过时了
 */

/**
 * 原本这些都是xml中进行配置的 现在转为代码
 */

@Deprecated//过时
//@Configuration
public class MyDataSourceConfig {

    /**
     * 在springboot中 默认的配置是 HikariDataSource
     * @ConditionalOnMissingBean({DataSource.class})
     * 当容器中注入DataSource时，则是以自己配置的  默认的则失效
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    /*因为在配置文件中写了数据库链接的内容 所以通过ConfigurationProperties把前缀表示出来可以了*/
//    @Bean
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/user?serverTimezone=GMT%2B8");
//        dataSource.setUsername("boot");
//        dataSource.setPassword("boot");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        //加入监控功能  和防火墙功能 也可以在配置文件中写这个
        dataSource.setFilters("stat,wall");
        return dataSource;
    }


    /**
     * 配置druid的监控页功能  就是druid连接数据库的所有信息
     * @return
     */
//    @Bean
    public ServletRegistrationBean statViewServlet(){
        //统计视图
        StatViewServlet servlet=new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean
        =new ServletRegistrationBean<>(servlet,"/druid/*");      //配置访问路径

//      配置登录密码和用户
        registrationBean.addInitParameter("loginUsername","admin");
        registrationBean.addInitParameter("loginPassword","123456");
        return registrationBean;

    }




    /**
     * WebStatFilter 用于采集web-jdbc关联监控的数据
     */
//    @Bean
    public FilterRegistrationBean webStatFilter(){
        WebStatFilter webStatFilter=new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean
                =new FilterRegistrationBean<>(webStatFilter);
        /*一样的 拦截哪些 放行哪些*/
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}

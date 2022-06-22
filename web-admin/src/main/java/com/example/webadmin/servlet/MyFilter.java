package com.example.webadmin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@Slf4j       /*   这里测试拦截静态资源  单*是servlet   双*是springBoot  */
//@WebFilter(urlPatterns = {"/css/*","/image/*"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("filter开始工作");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       log.info("filter初始化");
    }

    @Override
    public void destroy() {
        log.info("filter销毁");
    }
}

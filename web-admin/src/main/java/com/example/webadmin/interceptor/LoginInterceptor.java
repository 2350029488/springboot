package com.example.webadmin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * springboot拦截器2步
 * 1.配置好拦截器要拦截哪些请求
 * 2.把这些配置放在容器中
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*登陆检查逻辑*/
        HttpSession session=request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        System.out.println("拦截器用户信息"+loginUser);
//        如果域中有这个值则返回true 拦截放行
        if (loginUser!=null){
//            这里说明IndexController中的login可以跳转到main页面
            return true;
        }else {
            //拦截住      未登录，跳转至登录页
            request.setAttribute("msg","拦截器说明请先登录");
            System.out.println("被拦截");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /**
         * 在跳转页面之前进行
         */

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /**
         *在跳转页面之后执行
          */

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}

package com.lagou.edu.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 会在handler方法业务逻辑执行之前执行
     * 往往在这里完成权限校验工作
     * @return  返回值boolean代表是否放行，true代表放行，false代表中止
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        boolean flag = false;

        //判断请求路径是否是登录请求
        String requestURI = httpServletRequest.getRequestURI();
        if(requestURI.equals("/user/userLogin.do")){
            return true;
        }

        Cookie[] cookies = httpServletRequest.getCookies();
        if(cookies != null){
            for(Cookie cookie:cookies){
                //简单判断，只要设置了名称为user_info的cookie就说明是登录了
                String name = cookie.getName();
                if(name.equals("user_info")){
                    flag = true;
                }
            }
        }

        if(!flag){
            httpServletResponse.sendRedirect("/index.jsp");
            return flag;
        }
        return flag;
    }

    /**
     * 会在handler方法业务逻辑执行之后尚未跳转页面时执行
     * @param modelAndView  封装了视图和数据，此时尚未跳转页面呢，你可以在这里针对返回的数据和视图信息进行修改
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 页面已经跳转渲染完毕之后执行
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

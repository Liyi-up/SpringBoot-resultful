package com.liyi.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.component
 * @date 2020/5/6 11:40
 * @Copyright © liyi
 */
//登录检查
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    //目标方法执行前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        跳转之前获取seeion
        Object loginUser = request.getSession().getAttribute("loginUser");
        logger.info("loginUser="+String.valueOf(loginUser));
        if (loginUser == null) {
//            未登录,返回登录页面
//            返回登录页面
            request.setAttribute("fail","暂无用户访问权限");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        } else {
//            登录
            return true;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

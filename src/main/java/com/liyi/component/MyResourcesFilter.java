package com.liyi.component;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.component
 * @date 2020/5/7 8:54
 * @Copyright © liyi
 */

public class MyResourcesFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        //        设置请求编码格式
        System.out.println("测试");
        req.setCharacterEncoding("utf-8");  //post 改变(请求实体)
        //        设置响应编码格式
        resp.setContentType("text/css;charset=utf-8");//修改响应编码
        filterChain.doFilter(req, resp);

    }

    @Override
    public void destroy() {

    }
}

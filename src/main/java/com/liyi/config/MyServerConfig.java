package com.liyi.config;

import com.liyi.filter.MyFilter;
import com.liyi.listener.MyListener;
import com.liyi.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;
import java.util.Arrays;
import java.util.EventListener;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.config
 * @date 2020/5/13 11:40
 * @Copyright © liyi
 */
@Configuration
public class MyServerConfig {
    //    注册服务器三大组件
//    1.servlet
    @Bean
    public ServletRegistrationBean<MyServlet> myServlet() {
        ServletRegistrationBean<MyServlet> ServletRegistrationBean = new ServletRegistrationBean<>(new MyServlet(), "/MyServlet");
//设置启动顺序
        ServletRegistrationBean.setLoadOnStartup(1);

        return ServletRegistrationBean;
    }

    //    创建Servlet容器的定制器
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8081);
            }
        };
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        注册Filter
        filterFilterRegistrationBean.setFilter(new MyFilter());
//        指定需要拦截的servlet请求
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/MyServlet"));
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean MyListener() {
        ServletListenerRegistrationBean<EventListener> ServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return ServletListenerRegistrationBean;
    }
}

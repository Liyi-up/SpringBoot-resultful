package com.liyi.config;

import com.liyi.component.LoginHandlerInterceptor;
import com.liyi.component.MyErrorAttributes;
import com.liyi.component.MyLocaleResolver;
import com.liyi.component.MyResourcesFilter;
import lombok.extern.java.Log;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.context.ConfigurableWebServerApplicationContext;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.FilterRegistration;


/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.config
 * @date 2020/4/30 21:27
 * @Copyright © liyi
 */
//@EnableWebMvc //全面接管
//标注是一个标志类
//springBoot2.x一下版本继承 WebMvcAutoConfigurationAdapter
//SpringBoot2.x以上直接继承WebMvcAutoConfiguration扩展功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        浏览器发送请求,去到对应页面(首页)
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //    静态资源映射
    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/"};


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/webjars/**")) {
            registry.addResourceHandler("/webjars/**").addResourceLocations(
                    "classpath:/META-INF/resources/webjars/");
        }
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(
                    CLASSPATH_RESOURCE_LOCATIONS);
        }

    }

    //    添加自定义LocaleResolver组件
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    //    注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       拦截所有请求
//        静态资源:*.css
//        SpringBoot已经做好了静态资源映射所以现在不需要排除
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html", "/", "/user/login");
    }

    //    注册全局过滤器
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registry = new FilterRegistrationBean();
        registry.setFilter(new MyResourcesFilter());//添加过滤器
        registry.addUrlPatterns("/*css");//设置过滤路径，/*所有路径
        registry.addInitParameter("name", "alue");//添加默认参数
        registry.setName("MyFilter");//设置优先级
        registry.setOrder(1);//设置优先级
        return registry;
    }




}

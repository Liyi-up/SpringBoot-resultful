package com.liyi.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.component
 * @date 2020/5/5 21:03
 * @Copyright © liyi
 */
//在请求的连接上携带区域信息
//    自己编写区域信息解析器
public class MyLocaleResolver implements LocaleResolver {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
//        解析请求
//        从请求头不获取区域信息参数
        String l = request.getParameter("l");
//        设置一个默认的Locale，当没有携带参数则有默认的Locale区域信息
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(l)) {//如果区域信息参数不为空
//分割信息里面的_
            String[] split = l.split("_");
            logger.info(String.valueOf(split));
            locale = new Locale(split[0], split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

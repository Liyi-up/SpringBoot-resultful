package com.liyi.component;

import com.liyi.entities.ExceptionMsg;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.controller
 * @date 2020/5/10 23:18
 * @Copyright © liyi
 */
//给容器中加入我们自定义的ErrorAttributes

public class MyErrorAttributes extends DefaultErrorAttributes {
    //   返回值的map就是页面和json能获取的所有字段
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("author", "李毅");
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0); //0 代表请求域名 1 代表会话域
        map.put("ext",ext);
        return map;
    }
}

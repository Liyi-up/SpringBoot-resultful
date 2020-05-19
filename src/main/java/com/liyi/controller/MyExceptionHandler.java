package com.liyi.controller;

import com.liyi.entities.ExceptionMsg;
import com.liyi.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.controller
 * @date 2020/5/10 22:23
 * @Copyright © liyi
 */
@ControllerAdvice
public class MyExceptionHandler { //创建异常处理器
    //1.浏览器和客户端返回的都是json数据
//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public ExceptionMsg handleException(Exception e) {
//        return ExceptionMsg.add("user.notexist", e.getMessage());
//
//    }
    @ExceptionHandler(UserNotExistException.class)
    public String  handleException(Exception e,  HttpServletRequest request) {
        request.setAttribute("javax.servlet.error.status_code", 500);
        Map<String, Object> map = new HashMap<>();
        map.put("key", "usernotfund");
        request.setAttribute("ext", map);
        return "forward:/error";

    }
//    @ExceptionHandler(UserNotExistException.class)
//    public String  handleException(Exception e) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", "user.notexist");
//        map.put("message", e.getMessage());
//        return "forward:/error";
//
//    }
//    @ExceptionHandler(UserNotExistException.class)
//    public String  handleException(Exception e, HttpServletRequest request) {
//         ExceptionMsg.add("user.notexist", e.getMessage());
//        request.setAttribute("javax.servlet.error.status_code", 400);
//        return "forward:/error";
//    }
}

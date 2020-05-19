package com.liyi.controller;

import com.liyi.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.controller
 * @date 2020/4/30 13:03
 * @Copyright © liyi
 */

@Controller
public class HelloController {


    //    包装一些数据到页面展示
    @RequestMapping("success")
    public ModelAndView success(ModelAndView modelAndView) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("你好");
        strings.add("世界");
        strings.add("世界");
        strings.add("世界");
        modelAndView.setViewName("success");
        modelAndView.addObject("datas", strings);
        //classpath:/templates/success.html
        return modelAndView;
    }


    @RequestMapping("hello")
    public String hello(@RequestParam("user") String user) {

        return "helloworld";
    }
}
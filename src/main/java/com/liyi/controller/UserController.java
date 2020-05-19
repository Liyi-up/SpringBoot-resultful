package com.liyi.controller;

import com.liyi.entities.Msg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.controller
 * @date 2020/5/5 21:46
 * @Copyright © liyi
 */
@CrossOrigin(origins = "*")
@RequestMapping("user")
@Controller
public class UserController {
    Logger logger = LoggerFactory.getLogger(getClass());

    //    @PutMapping
//    @DeleteMapping
//    @GetMapping
    //   @RequestMapping(value = "login",method = RequestMethod.POST)
    @PostMapping(value = "login")
    public String login(String username, String password, Map<String, Object> map, HttpSession session) {

        logger.info(username);
        logger.info(password);
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {//登录成功
//            防止表单重复提交，可重定向解决
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } else {//登录失败
            String fail = "用户密码错误";
// Map，和modelAndView原理一样，同样是将数据一个一个放在requestScope中
            map.put("fail", fail);
            return "login";
        }

    }
}

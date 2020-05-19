package com.liyi.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.listener
 * @date 2020/5/13 14:44
 * @Copyright © liyi
 */
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized...web应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextInitialized...当前web项目销毁");

    }
}

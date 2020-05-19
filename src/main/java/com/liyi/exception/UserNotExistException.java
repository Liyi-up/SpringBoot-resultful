package com.liyi.exception;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.exception
 * @date 2020/5/10 22:01
 * @Copyright © liyi
 */
public class UserNotExistException extends RuntimeException {
    public UserNotExistException() {
        super("用户不存在");
    }
}

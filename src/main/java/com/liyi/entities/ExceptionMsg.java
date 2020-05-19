package com.liyi.entities;

/**
 * @author 李毅
 * @version V1.0
 * @Package com.liyi.entities
 * @date 2020/5/10 22:29
 * @Copyright © liyi
 */
public class ExceptionMsg {
    private String code;
    private Object message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public static ExceptionMsg add(String code,Object message) {
        ExceptionMsg exceptionMsg = new ExceptionMsg();
        exceptionMsg.setCode(code);
        exceptionMsg.setMessage(message);
        return exceptionMsg;
    }
}

package com.example.basketballteam.model;

public class BaseResult {
    private int code;
    private String msg;
    private Object data;

    public BaseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult() {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    // 构造方法和 getter/setter 方法根据你的需求进行定义

    // 其他自定义方法根据你的需求进行定义
}


package com.hc.bean;

import lombok.Data;

@Data
public class Result<T> {
    /**
     * 返回码
     */
    private Integer code;
    /**
     * 返回消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;
}

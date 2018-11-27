package com.hikari.yccdev.domain;

import java.io.Serializable;

/**
 * Created by gang.xu01@hand-china.com on 2018/11/23
 */
public class ErrorBody implements Serializable {

    private Integer code;

    private String message;

    private long timestamp = System.currentTimeMillis();

    @Override
    public String toString() {
        return "ErrorBody{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}

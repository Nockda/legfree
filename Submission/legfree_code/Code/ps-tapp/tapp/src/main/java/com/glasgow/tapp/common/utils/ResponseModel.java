package com.glasgow.tapp.common.utils;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 将对象转化为标准JSON响应格式
 */
@Data
public class ResponseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -8275057228952234785L;
    private int state=1;//响应状态（1：正常，0：异常）
    private String message="OK";
    private Object data;

    public ResponseModel(int state, String message, Object data){
        this.state=state;
        this.message=message;
        this.data=data;
    }
    public ResponseModel(int state, Object data){
        this.state=state;
        this.message=message;
        this.data=data;
    }
    public ResponseModel(Object data){
        this.data=data;
        if (data==null){
            this.message="无数据";
        }
    }
}

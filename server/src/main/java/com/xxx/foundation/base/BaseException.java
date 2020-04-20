package com.xxx.foundation.base;

import com.xxx.foundation.common.base.BaseResult;

/**
 * Created on 2020/4/16 15:24
 * author:crs
 * Description:自定义异常类
 */
public class BaseException extends RuntimeException {
    private int code;
    private String msg;

    public BaseException(int code, String msg) {
        this(code,msg,null);
    }

    public BaseException(int code, String msg,Throwable cause) {
        super(cause);
        this.code = code;
        this.msg = msg;
    }

    public BaseException(BaseResult baseResult) {
        this.code = baseResult.getCode();
        this.msg = baseResult.getMgs();
    }

    public BaseException(BaseResult baseResult,Throwable cause) {
        super(cause);
        this.code = baseResult.getCode();
        this.msg = baseResult.getMgs();
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
}

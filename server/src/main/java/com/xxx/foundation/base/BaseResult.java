//package com.xxx.foundation.base;
//
///**
// * Created on 2020/4/16 14:36
// * author:crs
// * Description:BaseResult
// */
//public enum BaseResult {
//
//    SUCCESS(0, "成功"),
//    FAILURE(-1, "失败"),
//    PARAM_IS_INVALID(100001, "参数无效"),
//    PARAM_IS_BLANK(100002, "参数为空"),
//    INTERNAL_SERVER_ERROR(500005, "服务器内部异常"),
//    PARAM_TYPE_BIND_ERROR(100003, "参数类型错误");
//
//    private int code;
//    private String mgs;
//
//    BaseResult(int code, String mgs) {
//        this.code = code;
//        this.mgs = mgs;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//
//    public String getMgs() {
//        return mgs;
//    }
//
//    public void setMgs(String mgs) {
//        this.mgs = mgs;
//    }
//}

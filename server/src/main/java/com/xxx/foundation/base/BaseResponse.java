//package com.xxx.foundation.base;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * Created on 2020/4/15 17:39
// * author:crs
// * Description:BaseResponse
// */
//public final class BaseResponse<T> {
//
//    private static final ObjectMapper mapper = new ObjectMapper();
//
//    private int code;
//    private String msg;
//    private T data;
//
//    private BaseResponse(Builder<T> builder) {
//        this.code = builder.code;
//        this.msg = builder.msg;
//        this.data = builder.data;
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
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public static BaseResponse toResponse() {
//        return toResponse(null);
//    }
//
//    public static BaseResponse toResponse(Object obj) {
//        return toResponse(obj, 200);
//    }
//
//    public static BaseResponse toResponse(Object obj, int code) {
//        return toResponse(obj, code, "success");
//    }
//
//    //适配传入枚举类型(正常返回异常),尽量避免直接抛出异常
//    public static BaseResponse toResponse(BaseResult baseResult) {
//        return toResponse(null, baseResult.getCode(), baseResult.getMgs());
//    }
//
//    public static BaseResponse toResponse(Object obj, int code, String str) {
//        return new Builder().setData(obj == null ? "" : obj).setCode(code).setMsg(str).builder();
//    }
//
//    public static class Builder<T> {
//        private T data = null;
//        private int code = 200;
//        private String msg = "success";
//
//        public Builder() {
//        }
//
//        public Builder<T> setCode(int code) {
//            this.code = code;
//            return this;
//        }
//
//        public Builder<T> setMsg(String msg) {
//            this.msg = msg;
//            return this;
//        }
//
//        public Builder<T> setData(T data) {
//            this.data = data;
//            return this;
//        }
//
//        public Builder<T> setData(String jsonStr, Class<T> classOfT) {
//            try {
//                this.data = mapper.readValue(jsonStr, classOfT);
//            } catch (Exception var4) {
//            }
//            return this;
//        }
//
//        public BaseResponse builder() {
//            return new BaseResponse(this);
//        }
//    }
//
//}

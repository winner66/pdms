//package com.chk.pdms.common.vo;
//
//import com.chk.pdms.common.exception.IError;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Map;
//
//public class Response<T> {
//    public static String SUCCESS_CODE = "200";
//
//    private String code = SUCCESS_CODE;
//
//    private String message;
//
//    private String popMsg;
//
//    private String extMessage;
//
//    private T data;
//
//    private Integer count;
//
//    private static final Map emptyMap = Collections.emptyMap();
//
//    private static final List emtypList = Collections.emptyList();
//
//    public static <T> Response<T> ok() {
//        return new Response(emptyMap);
//    }
//
//    public static <T> Response<T> ok(T data) {
////        if(data instanceof PageInfo) {
////            return ok((PageInfo)data);
////        }
////        if(data instanceof Page) {
////            return ok((Page)data);
////        }
//        if(data == null) {
//            return new Response(emptyMap);
//        }
//        return new Response<T>(data);
//    }
//
////    public static <T> Response<T> ok(PageInfo data) {
////        if(data == null) {
////            return new Response(emtypList);
////        }
////        Response response = new Response(data.getList());
////        //response.setCount(data.getPages());
////        return response;
////    }
////
////    public static <T> Response<T> ok(Page data) {
////        if(data == null) {
////            return new Response(emtypList);
////        }
////        Response response = new Response(data);
////        //response.setCount(data.getPages());
////        return response;
////    }
//
//    public static <T> Response<T> failed(IError error, String extMessage) {
//        return new Response(error.getCode(), error.getMessage(), extMessage, emptyMap);
//    }
//
//    public static <T> Response<T> failed(IError error) {
//        return failed(error, null);
//    }
//
//    public static <T> Response<T> failed(String code, String message, String extMessage) {
//        return new Response(code, message, extMessage, emptyMap);
//    }
//
//    public static <T> Response<T> failed(String code, String message) {
//        return failed(code, message, null);
//    }
//
//    public static <T> Response<T> failed(String code, String message, String extMessage,String popMsg) {
//        return new Response(code, message, extMessage,popMsg,emptyMap);
//    }
//
//
//
//    public Response() {
//    }
//
//    public Response(T data) {
//        this.data = data;
//    }
//
//
//    public Response(String code, String message, String extMessage, String popMsg, T data) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
//        this.extMessage = extMessage;
//        this.popMsg=popMsg;
//    }
//
//    public Response(String code, String message, String extMessage, T data) {
//        this.code = code;
//        this.message = message;
//        this.data = data;
//        this.extMessage = extMessage;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public String getExtMessage() {
//        return extMessage;
//    }
//
//    public Integer getCount() {
//        return count;
//    }
//
//    public void setCount(Integer count) {
//        this.count = count;
//    }
//
//    public String getPopMsg() {
//        return popMsg;
//    }
//
//    public void setPopMsg(String popMsg) {
//        this.popMsg = popMsg;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//}

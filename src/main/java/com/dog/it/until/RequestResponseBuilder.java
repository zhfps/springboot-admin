package com.dog.it.until;

import org.springframework.stereotype.Component;

@Component
public class RequestResponseBuilder {

    //成功，返回数据
    public static <T> RequestResponse<T> success(T t,RequestResponseCode code){
        RequestResponse<T> result = new RequestResponse<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        result.setData(t);
        return result;
    }

    //失败，返回失败信息
    public static <T> RequestResponse<T> error(T t, RequestResponseCode code, String error){
        RequestResponse<T> result = new RequestResponse<T>();
        result.setCode(code.getCode());
        result.setData(t);
        result.setMsg(code.getMsg());
        result.setError(error);
        return result;
    }
    //失败，返回失败信息
    public static <T> RequestResponse<T> error(RequestResponseCode code){
        RequestResponse<T> result = new RequestResponse<T>();
        result.setCode(code.getCode());
        result.setMsg(code.getMsg());
        return result;
    }

}

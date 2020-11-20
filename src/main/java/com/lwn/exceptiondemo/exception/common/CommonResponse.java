package com.lwn.exceptiondemo.exception.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CommonResponse<T> {
    private String version;
    private String code;
    private String message;
    private Integer flag;
    private T data;
    public CommonResponse(){
        this.code = "0";
        this.flag = 0;
    }

    /**
     * 返回数据和消息
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResponse ok(T data, String message,String code){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(data);
        commonResponse.setMessage(message);
        commonResponse.setCode(code);
        return commonResponse;
    }

    public static <T> CommonResponse ok(T data){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setData(data);
        return commonResponse;
    }

    public static <T> CommonResponse ok(String message,String code){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setMessage(message);
        commonResponse.setCode(code);
        return commonResponse;
    }

    /**
     * 错误返回
     * @param message
     * @param code
     * @param <T>
     * @return
     */
    public static <T> CommonResponse error(String message, String code){
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setMessage(message);
        commonResponse.setCode(code);
        return commonResponse;
    }

}

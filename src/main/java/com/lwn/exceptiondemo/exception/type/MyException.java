package com.lwn.exceptiondemo.exception.type;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import com.lwn.exceptiondemo.exception.code.Enum;
/**
 * @author lwnlwn987
 */
@Getter
@Slf4j
public class MyException extends RuntimeException {
    private final String code;
    private final String message;

    /**
     * 根据异常码、异常信息、异常包装统一异常
     * @param code
     * @param message
     * @param throwable
     */
    public MyException(String code,String message, Throwable throwable){
        super(message,throwable);
        this.message = message;
        this.code = code;
    }

    public MyException(String code,String message){
        super(message);
        this.message = message;
        this.code = code;
    }


    /**
     * 根据自定义异常枚举类包装统一异常
     * @param e
     */
    public MyException(Enum e){
        super(e.getMessage());
        this.code = e.getCode();
        this.message = e.getMessage();
    }



    /**
     * 根据自定义异常枚举类和异常包装统一异常
     * @param e
     * @param throwable
     */
    public MyException(Enum e, Throwable throwable){
        super(e.getMessage(),throwable);
        this.message = e.getMessage();
        this.code = e.getCode();
    }

    public String getCode() { return code; }

    @Override
    public String getMessage(){ return message; }



}

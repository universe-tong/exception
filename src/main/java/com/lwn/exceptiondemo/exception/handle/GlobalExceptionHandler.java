package com.lwn.exceptiondemo.exception.handle;

import com.lwn.exceptiondemo.exception.common.CommonResponse;
import com.lwn.exceptiondemo.exception.type.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author lwnlwn987
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 自定义异常类
     * @param e
     * @return
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public CommonResponse handleAppException(MyException e){
        String type = "自定义异常";
        log.error("{}: code:{} # message:{}",type,e.getCode(),e.getMessage());
        return CommonResponse.error(e.getMessage(),e.getCode());
    }

    /**
     * 处理参数校验异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        String type = "数据校验异常";
        log.error("{}: code:{} # message:{}",type,"-2",e.getMessage(),e);
        return CommonResponse.error(e.getMessage(),"-2");
    }

    public CommonResponse handleException(Exception e){
        String type = "系统异常";
        log.error("{}: code:{}",type,"-1",e);
        return CommonResponse.error(e.toString(),"-1");
    }





}

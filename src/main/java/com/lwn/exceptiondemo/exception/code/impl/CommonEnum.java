package com.lwn.exceptiondemo.exception.code.impl;

import com.lwn.exceptiondemo.exception.code.Enum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum CommonEnum implements Enum {
    INSERT_EXCEPTION("201","数据插入失败"),
    DELETE_EXCEPTION("202","数据删除失败"),
    UPDATE_EXCEPTION("203","数据更新失败"),
    SELECT_EXCEPTION("204","数据查询失败"),
    SUCCESS("200","成功！"),
    BODY_NOT_MATCH("400","数据格式不正确"),
    NOT_FOUND("404","未找到该资源"),
    INTERNAL_SERVER_ERROR("500","服务器内部错误"),
    SERVER_BUSY("503","服务器正忙,稍后再试")
    ;
    /**
     *异常码
     */
    private String code;
    /**
     *异常信息
     */
    private String message;
}

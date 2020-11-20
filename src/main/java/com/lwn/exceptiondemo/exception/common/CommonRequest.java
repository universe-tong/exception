package com.lwn.exceptiondemo.exception.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lwnlwn987
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonRequest<T> {
    /**
     * 应用程序版本
     */
    private String version;

    /**
     *标示请求的合法，删除token
     * 将token 放入http请求的报文头的 xtoken 属性中
     */
    private String token;

    /**
     * 全局流水-用户工号-YYYYMMDDHHMMSS，这个流水号记录于调用链中
     */
    private String globalMessageNo;

    /**
     * 服务之间发起请求的时候填写
     */
    private String serviceMessageNo;

    /**
     * 依据该字段区分 body 对象类型
     */
    private String serviceType;

    /**
     * 设备号
     */
    private String equipmentId;

    /**
     * 设备类型
     */
    private String equipmentType;

    /**
     * 例如 android 4.0 chrome 7
     * Ios 6.0 chrome 6
     */
    private String opAndBrowser;

    /**
     * 1标记加密 0不加密
     * 默认为 0
     */
    private Integer encodeFlag;

    /**
     * 业务对象
     */
    private T data;
}

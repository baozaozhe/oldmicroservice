package com.qhzk.as.common;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:28
 **/
public enum BaseResponseCode implements ResponseCodeInterface{
    /**
     * 接下来就要和前端约束好所有的码值以及含义
     */
    SUCCESS(0,"操作成功"),
    SYSTEM_ERROR(5000001,"系统错误"),
    METHOD_INVALIDATE(4000001,"数据校验出错"),
    DATA_ERROR(4000002,"传入数据异常"),
    TOKEN_NOT_NULL(4010001,"用户认证异常");

    //整个构造函数
    BaseResponseCode(int code,String msg){
        this.code=code;
        this.msg=msg;
    }

    private int code;
    private String msg;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}

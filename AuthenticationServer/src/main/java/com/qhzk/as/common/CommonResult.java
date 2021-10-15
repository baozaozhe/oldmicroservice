package com.qhzk.as.common;

import org.springframework.http.HttpStatus;

/**
 * @description: 返回数据对象
 * @author: Mr.Muxl
 * @create: 2021-06-28 13:23
 **/
public class CommonResult<T>
{
    private Integer code;
    private String message;
    private  T     data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 返回执行成功 +Void
     * @return
     */

    public static <T>CommonResult ofSuccess() {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage("执行成功");
        return result;
    }
    /**
     * 返回执行成功 +msg
     * @return
     */

    public static <T>CommonResult ofSuccess(String msg) {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage(msg);
        return result;
    }

    /**
     * 返回执行成功 +data
     * @return
     */
    public static <T>CommonResult ofSuccess(Object data) {
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage("执行成功");
        result.setData(data);
        return result;
    }
    /**
     * 返回执行成功 +data
     * @return
     */
    public static <T>CommonResult ofSuccess(String msg,Object data) {
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(HttpStatus.OK.value());
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
    /**
     * 返回执行失败+Void
     * @return
     */
    public static <T>CommonResult ofFail() {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMessage("执行失败");
        return result;
    }
    /**
     * 返回执行失败+msg
     * @return
     */
    public static <T>CommonResult ofFail(String msg) {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.BAD_REQUEST.value());
        result.setMessage(msg);
        return result;
    }
    /**
     * 返回执行失败 code + msg
     * @return
     */
    public static <T>CommonResult ofFail(Integer code,String msg) {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }
    /**
     * 返回执行失败 code + msg+data
     * @return
     */
    public static <T>CommonResult ofFail(Integer code, String msg, Object data) {
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
    /**
     * 令牌过期
     * @return
     */
    public static <T>CommonResult tokenExpired() {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.UNAUTHORIZED.value());
        result.setMessage("令牌已过期，请重新获取");
        return result;
    }
    /**
     * 参数错误
     * @return
     */
    public static <T>CommonResult parameterError(Object data){
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(7001);
        result.setMessage("参数错误");
        result.setData(data);
        return result;
    }

    /**
     * 参数错误
     * @return
     */
    public static <T>CommonResult parameterError(String msg,Object data){
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(7001);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }
    /**
     * 系统错误
     * @return
     */
    public static <T>CommonResult sysError(){
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(7002);
        result.setMessage("系统错误");
        return result;
    }
    /**
     * 系统错误
     * @return
     */
    public static <T>CommonResult sysError(String msg,Object data){
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(7002);
        result.setMessage(msg);
        result.setData(data);
        return result;
    }

    /**
     * 返回执行失败+Void
     * @return
     */
    public static <T>CommonResult ofNotRecord() {
        CommonResult<Void> result = new CommonResult<Void>();
        result.setCode(HttpStatus.NOT_FOUND.value());
        result.setMessage("无记录");
        return result;
    }

    /**
     * 返回执行成功 +Void
     * @return
     */

    public static <T>CommonResult ofSuccessCreate(Object data) {
        CommonResult<Object> result = new CommonResult<Object>();
        result.setCode(HttpStatus.CREATED.value());
        result.setMessage("创建成功");
        result.setData(data);
        return result;
    }
}

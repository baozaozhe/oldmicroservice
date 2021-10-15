package com.qhzk.as.common;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:27
 **/
public interface ResponseCodeInterface {
    /**
     * 返回的码的一个获取
     * @return
     */
    int getCode();

    /**
     * 返回消息的获取
     * @return
     */
    String getMsg();
}

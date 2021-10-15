package com.qhzk.as.common;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-07-12 15:46
 **/
public class BusinessException extends RuntimeException{
    private int messageCode;
    private String defaultMesaage;
    public BusinessException(int messageCode,String defaultMesaage){
        super(defaultMesaage);
        this.messageCode=messageCode;
        this.defaultMesaage=defaultMesaage;
    }

    public String getDefaultMesaage() {
        return defaultMesaage;
    }

    public int getMessageCode() {
        return messageCode;
    }
}

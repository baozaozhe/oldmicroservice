package com.qhzk.lzx.entity;

import java.io.Serializable;

/**
 * @description:
 * @author: Mr.Muxl
 * @create: 2021-08-02 11:23
 **/
public class UserInfo implements Serializable {
    private   String id ;
    private   String name ;
    private   String phone ;

    public UserInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public UserInfo(String id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }
}

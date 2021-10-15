package com.qhzk.autogen.freemark.util;

/**
 * @description: 自动生成信息类
 * @author: Mr.Muxl
 * @create: 2021-08-05 10:30
 **/
public class AutoInfo<T> {

    private  String tablename ;
    private  String title ;
    private Class<T> modelClass;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Class<T> getModelClass() {
        return modelClass;
    }

    public void setModelClass(Class<T> modelClass) {
        this.modelClass = modelClass;
    }

    public AutoInfo(String tablename, String title, Class<T> modelClass) {
        this.tablename = tablename;
        this.title = title;
        this.modelClass = modelClass;
    }
}

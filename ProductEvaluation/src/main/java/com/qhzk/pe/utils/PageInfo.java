package com.qhzk.pe.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 分页实体类
 * @author: Mr.Muxl
 * @create: 2021-06-28 10:28
 **/
@ApiModel(value = "分页实体类")
public class PageInfo<E> implements Serializable {
    @ApiModelProperty(value = "当前页码")
    private int pageNo = 1;
    @ApiModelProperty(value = "每页显示条数")
    private int pageSize=15;
    @ApiModelProperty(value = "数据总数")
    private int totalCount=0;
    @ApiModelProperty(value = "记录开始数")
    private int start=0;
    @ApiModelProperty(value = "页码总数")
    private int totalPages=0;
    @ApiModelProperty(value = "分页数据")
    private List<E> dates;

    public PageInfo(){
        this.start = (this.pageNo -1) * this.pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.start = (this.pageNo -1) * this.pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        double d = (double)totalCount / this.pageSize;
        this.totalPages =(int)Math.ceil(d);
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.start = (this.pageNo -1) * this.pageSize;
        this.pageNo = pageNo;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotalPages() {
        double d =(double) this.totalCount / this.pageSize;
        return (int)Math.ceil(d);
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<E> getDates() {
        return dates;
    }

    public void setDates(List<E> dates) {
        this.dates = dates;
    }
}

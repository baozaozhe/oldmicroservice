package com.qhzk.as.service;

import com.qhzk.as.entity.ColumnInfo;
import com.qhzk.as.entity.GenConfig;
import com.qhzk.as.entity.Tables;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description: 代码生成服务
 * @author: Mr.Muxl
 * @create: 2021-08-26 16:12
 **/
public interface GeneratorService{
    /**
     * 查询数据库元数据
     * @param name 表名
     * @return /
     */
    List<Tables> getTables(String name);
    /**
     * 查询表的字段信息
     * @param name 表名
     * @return /
     */
    List<ColumnInfo> queryColumnInfos(String name);

    /**
     * 同步表数据
     * @param columnInfos /
     * @param columnInfoList /
     */
    void sync(List<ColumnInfo> columnInfos, List<ColumnInfo> columnInfoList);

    /**
     * 代码生成
     * @param genConfig 配置信息
     * @param columns 字段信息
     */
    void generator(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 预览
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @return /
     */
    ResponseEntity<Object> preview(GenConfig genConfig, List<ColumnInfo> columns);

    /**
     * 打包下载
     * @param genConfig 配置信息
     * @param columns 字段信息
     * @param request /
     * @param response /
     */
    void download(GenConfig genConfig, List<ColumnInfo> columns, HttpServletRequest request, HttpServletResponse response);

}

package com.qhzk.as.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ZipUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qhzk.as.entity.ColumnInfo;
import com.qhzk.as.entity.GenConfig;
import com.qhzk.as.entity.Tables;
import com.qhzk.as.exception.BadRequestException;
import com.qhzk.as.mapper.ColumnInfoMapper;
import com.qhzk.as.mapper.GeneratorMapper;
import com.qhzk.as.service.GeneratorService;
import com.qhzk.as.utils.FileUtil;
import com.qhzk.as.utils.GenUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 代码生成服务实现类
 * @author: Mr.Muxl
 * @create: 2021-08-26 16:15
 **/
@Service
public class GeneratorServiceImpl implements GeneratorService {
    @Resource
    private GeneratorMapper generatorMapper;
    @Resource
    private ColumnInfoMapper columninfomapper;
    @Override
    public List<Tables> getTables(String name) {
        return generatorMapper.getTables(name);
    }

    @Override
    public List<ColumnInfo> queryColumnInfos(String name) {

        return generatorMapper.queryColumnInfos(name);
    }

    @Override
    public void sync(List<ColumnInfo> columnInfos, List<ColumnInfo> columnInfoList) {
        // 第一种情况，数据库类字段改变或者新增字段
        for (ColumnInfo columnInfo : columnInfoList) {
            // 根据字段名称查找
            List<ColumnInfo> columns = columnInfos.stream().filter(c -> c.getColumnName().equals(columnInfo.getColumnName())).collect(Collectors.toList());
            // 如果能找到，就修改部分可能被字段
            if (CollectionUtil.isNotEmpty(columns)) {
                ColumnInfo column = columns.get(0);
                column.setColumnType(columnInfo.getColumnType());
                column.setExtra(columnInfo.getExtra());
                column.setKeyType(columnInfo.getKeyType());
                if (null ==column.getRemark()||"".equals(column.getRemark())) {
                    column.setRemark(columnInfo.getRemark());
                }
                columninfomapper.insert(column);
            } else {
                // 如果找不到，则保存新字段信息
                columninfomapper.insert(columnInfo);
            }
        }
        // 第二种情况，数据库字段删除了
        for (ColumnInfo columnInfo : columnInfos) {
            // 根据字段名称查找
            List<ColumnInfo> columns = columnInfoList.stream().filter(c -> c.getColumnName().equals(columnInfo.getColumnName())).collect(Collectors.toList());
            // 如果找不到，就代表字段被删除了，则需要删除该字段
            if (CollectionUtil.isEmpty(columns)) {
                QueryWrapper<ColumnInfo> wrapper = new QueryWrapper<>();
                wrapper.setEntity(columnInfo);
                columninfomapper.delete(wrapper);
            }
        }
    }

    @Override
    public void generator(GenConfig genConfig, List<ColumnInfo> columns) {
        if (genConfig.getConfigId() == null) {
            throw new BadRequestException("请先配置生成器");
        }
        try {
            GenUtil.generatorCode(columns, genConfig);
        } catch (IOException e) {
            throw new BadRequestException("生成失败，请手动处理已生成的文件");
        }
    }

    @Override
    public ResponseEntity<Object> preview(GenConfig genConfig, List<ColumnInfo> columns) {
        if (genConfig.getConfigId() == null) {
            throw new BadRequestException("请先配置生成器");
        }
        List<Map<String, Object>> genList = GenUtil.preview(columns, genConfig);
        return new ResponseEntity<>(genList, HttpStatus.OK);
    }

    @Override
    public void download(GenConfig genConfig, List<ColumnInfo> columns, HttpServletRequest request, HttpServletResponse response) {
        if (genConfig.getConfigId() == null) {
            throw new BadRequestException("请先配置生成器");
        }
        try {
            File file = new File(GenUtil.download(columns, genConfig));
            String zipPath = file.getPath() + ".zip";
            ZipUtil.zip(file.getPath(), zipPath);
            FileUtil.downloadFile(request, response, new File(zipPath), true);
        } catch (IOException e) {
            throw new BadRequestException("打包失败");
        }
    }
}

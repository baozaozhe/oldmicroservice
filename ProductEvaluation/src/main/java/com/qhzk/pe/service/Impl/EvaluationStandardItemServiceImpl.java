package com.qhzk.pe.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.qhzk.pe.utils.SnowflakeIdWorker;
import org.springframework.stereotype.Service;

import com.qhzk.pe.data.EvaluationStandardItemData;
import com.qhzk.pe.utils.PageInfo;
import com.qhzk.pe.service.EvaluationStandardItemService;
import com.qhzk.pe.mapper.EvaluationStandardItemCustomMapper;

/**
 * 评价标准明细 Service实现类，评价标准明细 Service实现类
 * @author: Mr.Muxl
 * @date 2021-07-20
 */

@Service
public class EvaluationStandardItemServiceImpl implements EvaluationStandardItemService{
    @Resource
    private EvaluationStandardItemCustomMapper evaluationstandarditemcustommapper;

    @Override
    public boolean addEvaluationStandardItem(EvaluationStandardItemData evaluationstandarditemdata) {
        evaluationstandarditemdata.setPkid(SnowflakeIdWorker.generateId());
        evaluationstandarditemdata.setIsdelete("N");
        int count = evaluationstandarditemcustommapper.insert(evaluationstandarditemdata);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean delEvaluationStandardItemById(long id) {
        EvaluationStandardItemData evaluationstandarditemdata = evaluationstandarditemcustommapper.selectByPrimaryKey(id);
        if(null !=evaluationstandarditemdata){
            int count = evaluationstandarditemcustommapper.deleteLogicByPrimaryKey(id);
            if(count>0){
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean updateEvaluationStandardItem(EvaluationStandardItemData evaluationstandarditemdata) {
        int count = evaluationstandarditemcustommapper.updateByPrimaryKey(evaluationstandarditemdata);
        if(count>0){
            return true;
        }
        return false;
    }

    @Override
    public  EvaluationStandardItemData getEvaluationStandardItemById(long id) {
        return evaluationstandarditemcustommapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<EvaluationStandardItemData> queryPageInfo(PageInfo page, EvaluationStandardItemData evaluationstandarditemdata) {
        Long count = evaluationstandarditemcustommapper.countEvaluationStandardItemPageInfo(evaluationstandarditemdata);
        page.setTotalCount(count.intValue());
        List<EvaluationStandardItemData> evaluationstandarditems = evaluationstandarditemcustommapper.queryEvaluationStandardItemPageInfo(page,evaluationstandarditemdata);
        page.setDates(evaluationstandarditems);
        return page;
    }

    @Override
    public List<EvaluationStandardItemData> getAllEvaluationStandardItems(EvaluationStandardItemData evaluationstandarditemdata) {
        List<EvaluationStandardItemData> evaluationstandarditems = evaluationstandarditemcustommapper.queryEvaluationStandardItemPageInfo(null,evaluationstandarditemdata);
        return  evaluationstandarditems;
    }
    @Override
    public int batchDeleteInfo(List<String> infos) {
        return evaluationstandarditemcustommapper.batchLogicDeleteInfo(infos);
    }
}

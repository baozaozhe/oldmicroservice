package com.qhzk.pa.controller;

import com.qhzk.pa.model.Specimen;
import com.qhzk.pa.service.ProductEvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 产品评价服务调用
 * @author: Mr.Muxl
 * @create: 2021-06-23 13:46
 **/
@RestController
@RequestMapping("/specimen")
@Slf4j
public class ProductEvaluationController {

    @Resource
    private ProductEvaluationService peservice;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Specimen>> listAllSpecimens(Specimen specimen) {
        return peservice.listAllSpecimens(specimen);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Specimen> getSpecimenById(@PathVariable("id") long id) {
        return peservice.getSpecimenById(id);
    }
}

package com.qhzk.pa.service;

import com.qhzk.pa.model.Specimen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description: 产品评价服务调用
 * @author: Mr.Muxl
 * @create: 2021-06-23 13:54
 **/
@Component
@FeignClient(value = "GATEWAYSERVER")
public interface ProductEvaluationService {
    @GetMapping(value = "/pe/specimen/list")
    public ResponseEntity<List<Specimen>> listAllSpecimens(Specimen specimen);

    @RequestMapping(value = "/pe/specimen/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Specimen> getSpecimenById(@PathVariable("id") long id) ;
}

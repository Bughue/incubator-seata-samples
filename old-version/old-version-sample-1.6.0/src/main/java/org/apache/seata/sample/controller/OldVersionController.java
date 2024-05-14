package org.apache.seata.sample.controller;

import org.apache.seata.sample.entity.OrderRequest;
import org.apache.seata.sample.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ?
 **/
@RestController
public class OldVersionController {

    @Resource
    private OrderService orderService;
    @PostMapping(value = "/order")
    public String hello(@RequestBody OrderRequest request) {
        orderService.create(request.getUserId(), request.getCommodityCode(), request.getOrderCount());
        return "ok";
    }
}

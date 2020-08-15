package com.galaxy.mecury.controller.api;

import com.galaxy.mecury.entity.Order;
import com.galaxy.mecury.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
    public Order selectById(@PathVariable("id") Integer id) {
        return orderService.selectAllByPrimaryKey(id);
    }
}

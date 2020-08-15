package com.galaxy.mecury.service.impl;

import com.galaxy.mecury.dao.OrderMapper;
import com.galaxy.mecury.entity.Order;
import com.galaxy.mecury.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired(required = false)
    private OrderMapper orderMapper;

    @Override
    public int insertSelective(Order record) {
        return orderMapper.insertSelective(record);
    }

    @Override
    public Order selectByPrimaryKey(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Order record) {
        return orderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Order selectAllByPrimaryKey(Integer id) {
        return orderMapper.selectAllByPrimaryKey(id);
    }
}

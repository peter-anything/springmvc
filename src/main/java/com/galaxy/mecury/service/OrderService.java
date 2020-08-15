package com.galaxy.mecury.service;

import com.galaxy.mecury.entity.Order;

public interface OrderService {
    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    Order selectAllByPrimaryKey(Integer id);
}

package com.galaxy.mecury.service.impl;

import com.galaxy.mecury.dao.GoodMapper;
import com.galaxy.mecury.entity.Good;
import com.galaxy.mecury.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceImpl implements GoodService {
    @Autowired(required = false)
    private GoodMapper goodMapper;

    @Override
    public int insertSelective(Good record) {
        return goodMapper.insertSelective(record);
    }

    @Override
    public Good selectByPrimaryKey(Integer id) {
        return goodMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Good record) {
        return goodMapper.updateByPrimaryKeySelective(record);
    }
}

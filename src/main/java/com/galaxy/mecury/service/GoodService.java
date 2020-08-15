package com.galaxy.mecury.service;

import com.galaxy.mecury.entity.Good;

public interface GoodService {
    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Good record);
}

package com.galaxy.mecury.service;

import com.galaxy.mecury.entity.Mechant;

public interface MechantService {
    int insertSelective(Mechant record);

    Mechant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mechant record);
}

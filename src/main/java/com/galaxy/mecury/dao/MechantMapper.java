package com.galaxy.mecury.dao;

import com.galaxy.mecury.entity.Mechant;

public interface MechantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mechant record);

    int insertSelective(Mechant record);

    Mechant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mechant record);

    int updateByPrimaryKey(Mechant record);
}
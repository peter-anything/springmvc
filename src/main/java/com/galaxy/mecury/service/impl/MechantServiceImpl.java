package com.galaxy.mecury.service.impl;

import com.galaxy.mecury.dao.GoodMapper;
import com.galaxy.mecury.dao.MechantMapper;
import com.galaxy.mecury.entity.Mechant;
import com.galaxy.mecury.service.MechantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
@Service
public class MechantServiceImpl implements MechantService {
    @Autowired(required = false)
    private MechantMapper mechantMapper;

    @Override
    public int insertSelective(Mechant record) {
        return mechantMapper.insertSelective(record);
    }

    @Override
    public Mechant selectByPrimaryKey(Integer id) {
        mechantMapper.selectByPrimaryKey(id);
        mechantMapper.selectByPrimaryKey(id);
        mechantMapper.selectByPrimaryKey(id);
        mechantMapper.selectByPrimaryKey(2);
        return mechantMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Mechant record) {
        return mechantMapper.updateByPrimaryKeySelective(record);
    }
}

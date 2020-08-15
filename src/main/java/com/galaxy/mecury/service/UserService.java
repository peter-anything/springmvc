package com.galaxy.mecury.service;

import com.galaxy.mecury.entity.User;

public interface UserService {
    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);
}

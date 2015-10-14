package com.liuwill.simpleMyBatis.dao;

import com.liuwill.simpleMyBatis.entity.CommonUserModel;

public interface CommonUserModelMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(CommonUserModel record);

    int insertSelective(CommonUserModel record);

    CommonUserModel selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(CommonUserModel record);

    int updateByPrimaryKey(CommonUserModel record);
}
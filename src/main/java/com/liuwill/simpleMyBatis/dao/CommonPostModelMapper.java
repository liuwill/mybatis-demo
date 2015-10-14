package com.liuwill.simpleMyBatis.dao;

import com.liuwill.simpleMyBatis.entity.CommonPostModel;

public interface CommonPostModelMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(CommonPostModel record);

    int insertSelective(CommonPostModel record);

    CommonPostModel selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(CommonPostModel record);

    int updateByPrimaryKeyWithBLOBs(CommonPostModel record);

    int updateByPrimaryKey(CommonPostModel record);
}
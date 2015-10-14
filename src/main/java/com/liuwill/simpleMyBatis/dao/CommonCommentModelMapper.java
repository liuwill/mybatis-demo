package com.liuwill.simpleMyBatis.dao;

import com.liuwill.simpleMyBatis.entity.CommonCommentModel;
import com.liuwill.simpleMyBatis.entity.CommonCommentModelWithBLOBs;

public interface CommonCommentModelMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(CommonCommentModelWithBLOBs record);

    int insertSelective(CommonCommentModelWithBLOBs record);

    CommonCommentModelWithBLOBs selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(CommonCommentModelWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CommonCommentModelWithBLOBs record);

    int updateByPrimaryKey(CommonCommentModel record);
}
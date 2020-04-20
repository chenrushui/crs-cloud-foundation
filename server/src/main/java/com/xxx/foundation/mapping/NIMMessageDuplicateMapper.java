package com.xxx.foundation.mapping;

import com.xxx.foundation.entity.NIMMessageDuplicate;

public interface NIMMessageDuplicateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(NIMMessageDuplicate record);

    int insertSelective(NIMMessageDuplicate record);

    NIMMessageDuplicate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(NIMMessageDuplicate record);

    int updateByPrimaryKeyWithBLOBs(NIMMessageDuplicate record);

    int updateByPrimaryKey(NIMMessageDuplicate record);
}
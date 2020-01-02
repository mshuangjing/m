package com.byzoro.mapper;

import com.byzoro.entity.SYSRoleResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SYSRoleResourceMapper {
    int deleteByPrimaryKey(SYSRoleResource key);

    int insert(SYSRoleResource record);

    int insertSelective(SYSRoleResource record);
}
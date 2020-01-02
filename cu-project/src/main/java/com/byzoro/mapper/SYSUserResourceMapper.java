package com.byzoro.mapper;

import com.byzoro.entity.SYSUserResource;
import org.springframework.stereotype.Repository;

@Repository
public interface SYSUserResourceMapper {
    int deleteByPrimaryKey(SYSUserResource key);

    int insert(SYSUserResource record);

    int insertSelective(SYSUserResource record);
}
package com.byzoro.mapper;

import com.byzoro.entity.BasicUser;
import org.springframework.stereotype.Repository;

/**
 * BasicUserMapper继承基类
 */
@Repository
public interface BasicUserMapper extends MyBatisBaseDao<BasicUser, Long> {
}
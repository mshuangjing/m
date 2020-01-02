package com.byzoro.mapper;

import com.byzoro.entity.PolicyAccessQuery;
import org.springframework.stereotype.Repository;

/**
 * PolicyAccessQueryMapper继承基类
 */
@Repository
public interface PolicyAccessQueryMapper extends MyBatisBaseDao<PolicyAccessQuery, Long> {
}
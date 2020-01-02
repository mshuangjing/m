package com.byzoro.mapper;

import com.byzoro.entity.PolicyBasicData;
import org.springframework.stereotype.Repository;

/**
 * PolicyBasicDataMapper继承基类
 */
@Repository
public interface PolicyBasicDataMapper extends MyBatisBaseDao<PolicyBasicData, Long> {
}
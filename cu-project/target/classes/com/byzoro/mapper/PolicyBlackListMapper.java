package com.byzoro.mapper;

import com.byzoro.entity.PolicyBlackList;
import org.springframework.stereotype.Repository;

/**
 * PolicyBlackListMapper继承基类
 */
@Repository
public interface PolicyBlackListMapper extends MyBatisBaseDao<PolicyBlackList, Long> {
}
package com.byzoro.mapper;

import com.byzoro.entity.BasicDomain;
import org.springframework.stereotype.Repository;

/**
 * BasicDomainMapper继承基类
 */
@Repository
public interface BasicDomainMapper extends MyBatisBaseDao<BasicDomain, Long> {
}
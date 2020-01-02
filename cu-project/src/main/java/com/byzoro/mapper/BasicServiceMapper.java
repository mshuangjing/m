package com.byzoro.mapper;

import com.byzoro.entity.BasicService;
import org.springframework.stereotype.Repository;

/**
 * BasicServiceMapper继承基类
 */
@Repository
public interface BasicServiceMapper extends MyBatisBaseDao<BasicService, Long> {
}
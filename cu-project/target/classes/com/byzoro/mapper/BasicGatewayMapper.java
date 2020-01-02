package com.byzoro.mapper;

import com.byzoro.entity.BasicGateway;
import org.springframework.stereotype.Repository;

/**
 * BasicGatewayMapper继承基类
 */
@Repository
public interface BasicGatewayMapper extends MyBatisBaseDao<BasicGateway, Long> {
}
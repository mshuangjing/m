package com.byzoro.mapper;

import com.byzoro.entity.BasicHouse;
import org.springframework.stereotype.Repository;

/**
 * BasicHouseMapper继承基类
 */
@Repository
public interface BasicHouseMapper extends MyBatisBaseDao<BasicHouse, Long> {
}
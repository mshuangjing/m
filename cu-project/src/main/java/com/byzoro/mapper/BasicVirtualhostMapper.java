package com.byzoro.mapper;

import com.byzoro.entity.BasicVirtualhost;
import org.springframework.stereotype.Repository;

/**
 * BasicVirtualhostMapper继承基类
 */
@Repository
public interface BasicVirtualhostMapper extends MyBatisBaseDao<BasicVirtualhost, Long> {
}
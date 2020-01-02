package com.byzoro.mapper;

import com.byzoro.entity.BasicFrame;
import org.springframework.stereotype.Repository;

/**
 * BasicFrameMapper继承基类
 */
@Repository
public interface BasicFrameMapper extends MyBatisBaseDao<BasicFrame, Long> {
}
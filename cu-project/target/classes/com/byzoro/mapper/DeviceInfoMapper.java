package com.byzoro.mapper;

import com.byzoro.entity.DeviceInfo;
import org.springframework.stereotype.Repository;

/**
 * DeviceInfoMapper继承基类
 */
@Repository
public interface DeviceInfoMapper extends MyBatisBaseDao<DeviceInfo, Long> {
}
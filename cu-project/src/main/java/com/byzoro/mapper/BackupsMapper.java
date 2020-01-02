package com.byzoro.mapper;

import com.byzoro.entity.Backups;
import org.springframework.stereotype.Repository;

/**
 * BackupsMapper继承基类
 */
@Repository
public interface BackupsMapper extends MyBatisBaseDao<Backups, Long> {
}
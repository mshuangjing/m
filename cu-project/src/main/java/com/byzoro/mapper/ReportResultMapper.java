package com.byzoro.mapper;

import com.byzoro.entity.ReportResult;
import org.springframework.stereotype.Repository;

/**
 * ReportResultMapper继承基类
 */
@Repository
public interface ReportResultMapper extends MyBatisBaseDao<ReportResult, Long> {
}
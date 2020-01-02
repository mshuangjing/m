package com.byzoro.mapper;

import com.byzoro.entity.SYSLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SYSLogMapper {

    public List<SYSLog> getList(Map<String, Object> params);

    public int getTotalNum(Object queryName);

    public int addSysLog(SYSLog sysLog);

    public List<SYSLog> getSysLogList();

    int addTest(String loginName);

    int getTotal(Map<String, String> params);

    List<SYSLog> queryAllByParams(Map<String, String> params);
}
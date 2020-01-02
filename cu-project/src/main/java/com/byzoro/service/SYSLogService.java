package com.byzoro.service;

import com.byzoro.utils.ViewResult;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.Map;


public interface SYSLogService {

    JsonObject getConfigJson(Map<String, Object> params);

    int insertSyslog(String optContent, String beforeUpdate, String afterUpate, String deviceCode, String optName);

    int getTotalNum();

    ArrayList<ArrayList<?>> getSysLogList();

    int addTest(String loginName);

    ViewResult getListByParams(Map<String, String> params);
}
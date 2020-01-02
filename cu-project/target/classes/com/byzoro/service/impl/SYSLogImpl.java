package com.byzoro.service.impl;

import com.byzoro.entity.SYSLog;
import com.byzoro.mapper.SYSLogMapper;
import com.byzoro.service.SYSLogService;
import com.byzoro.utils.ViewResult;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author
 * @version 1.0
 * @date
 */
@Service
public class SYSLogImpl implements SYSLogService {

    @Resource
    private SYSLogMapper sysLogMapper;

    @Override
    public JsonObject getConfigJson(Map<String, Object> params) {
        int totalNum;
        Map<String, Object> mapsParam = new HashMap<String, Object>();
        JsonObject jsonObj = new JsonObject();

        mapsParam.put("pageSize", Integer.parseInt(params.get("pageSize").toString()));

        if (params.get("loginName") != null && !"".equals(params.get("loginName"))) {
            mapsParam.put("loginName", params.get("loginName"));
            totalNum = sysLogMapper.getTotalNum(mapsParam);
        } else if (params.get("detaTime") != null && !"".equals(params.get("detaTime"))) {
            mapsParam.put("detaTime", params.get("detaTime"));
            totalNum = sysLogMapper.getTotalNum(mapsParam);
        } else if (params.get("ip") != null && !"".equals(params.get("ip"))) {
            mapsParam.put("ip", params.get("ip"));
            totalNum = sysLogMapper.getTotalNum(mapsParam);
        } else if (params.get("type") != null && !"".equals(params.get("type"))) {
            mapsParam.put("type", params.get("type"));
            totalNum = sysLogMapper.getTotalNum(mapsParam);
        } else {
            totalNum = sysLogMapper.getTotalNum(null);
        }
        if (totalNum == 0) {
            jsonObj.addProperty("status", 0);
            jsonObj.addProperty("info", "no data");
            return jsonObj;
        }
        List<SYSLog> sysLog = null;

        Integer begin = (Integer.parseInt(params.get("pageNum").toString()) - 1) * Integer.parseInt(params.get("pageSize").toString());
        mapsParam.put("begin", begin);
        sysLog = sysLogMapper.getList(mapsParam);

        if (!sysLog.isEmpty()) {
            JsonArray arrayJson = new JsonArray();
            JsonObject jsondata = null;
            for (int i = 0; i < sysLog.size(); i++) {
                SYSLog sysLogs = sysLog.get(i);
                jsondata = new JsonObject();
                jsondata.addProperty("id", sysLogs.getId());
                jsondata.addProperty("loginName", sysLogs.getLoginName());
                jsondata.addProperty("clientIp", sysLogs.getClientIp());
                jsondata.addProperty("createTime", sysLogs.getCreateTime());
                jsondata.addProperty("optContent", sysLogs.getOptContent());
                jsondata.addProperty("beforeOperation", sysLogs.getBeforeOperation());
                jsondata.addProperty("afterOperation", sysLogs.getAfterOperation());
                arrayJson.add(jsondata);
                jsondata = null;
            }
            jsonObj.addProperty("status", 1);
            jsonObj.addProperty("info", "");
            jsonObj.addProperty("total", totalNum);
            jsonObj.add("syslog", arrayJson);
        } else {
            jsonObj.addProperty("status", 0);
            jsonObj.addProperty("info", "no data");
        }

        return jsonObj;

    }

    /**
     * 操作日志增加接口
     * @param optName
     * @param beforeUpdate
     * @param afterUpate
     * @return
     */
    @Override
    public int insertSyslog(String optContent, String beforeUpdate, String afterUpate,String deviceCode,String optName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //ip地址
        String ip = getRemoteHost(request);
        //登录名
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("loginName");
        //数据封装实体进行数据插入
        SYSLog sysLog = new SYSLog();
        sysLog.setBeforeOperation(beforeUpdate);
        sysLog.setAfterOperation(afterUpate);
        sysLog.setOptContent(optContent);
        sysLog.setLoginName(username);
        sysLog.setDeviceCode(deviceCode);
        sysLog.setOptName(optName);
        sysLog.setClientIp(ip);
        sysLog.setCreateTime(String.valueOf(System.currentTimeMillis()/1000));//转换为秒的时间戳
        int res = sysLogMapper.addSysLog(sysLog);
        if (res != 1) {
            return 0;
        } else {
            return res;
        }

    }

    public String getRemoteHost(javax.servlet.http.HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    @Override
    public int getTotalNum() {
        return sysLogMapper.getTotalNum(null);
    }

    @Override
    public ArrayList<ArrayList<?>> getSysLogList() {

        List<SYSLog> exList = sysLogMapper.getSysLogList();
        ArrayList<ArrayList<?>> data = new ArrayList<ArrayList<?>>();

        for (SYSLog syslog : exList) {

            ArrayList<String> sysUserLog = new ArrayList<>();

            sysUserLog.add(syslog.getLoginName());
            sysUserLog.add(syslog.getClientIp());
            sysUserLog.add(syslog.getCreateTime());
            sysUserLog.add(syslog.getOptContent());
            sysUserLog.add(syslog.getBeforeOperation());
            sysUserLog.add(syslog.getAfterOperation());
            data.add(sysUserLog);
        }

        return data;
    }

    //@Transactional
    @Override
    public int addTest(String loginName) {
        int i = sysLogMapper.addTest(loginName);
        if (loginName.length()>0) {
            throw new RuntimeException("测试增加");
        }
        return i;
    }

    /**
     * 操作查询所有日志
     * @param params
     * @return
     */
    @Override
    public ViewResult getListByParams(Map<String, String> params) {

        ViewResult viewResult = new ViewResult();
        //页面-1,从0页开始计算,乘以条数
        params.put("pageCurr", String.valueOf((Integer.parseInt(params.get("pageNum")) - 1) * Integer.parseInt(params.get("pageSize"))));
        //查询总条数
        int sysTotal = sysLogMapper.getTotal(params);
        //通过条件查询所有数据
        List<SYSLog> paramsList = sysLogMapper.queryAllByParams(params);
        //数组不等于空传给前端数据
        if (!paramsList.isEmpty()) {
            viewResult.setData(paramsList);
            viewResult.setTotalNum(sysTotal);
        } else {
            viewResult.setStatus(ViewResult.ERROR);
        }
        return viewResult;
    }

}
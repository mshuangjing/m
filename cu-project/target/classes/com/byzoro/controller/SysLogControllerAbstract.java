package com.byzoro.controller;

import com.byzoro.service.SYSLogService;
import com.byzoro.utils.CommonUtil;
import com.byzoro.utils.ViewResult;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* @Author mashuangjing
* @Date 2019/12/26 15:58
*/
@SuppressWarnings("AlibabaClassNamingShouldBeCamel")
@Controller
@RequestMapping(value="syslog")
public class SysLogControllerAbstract {


	public static Logger logger = LoggerFactory.getLogger(SysLogControllerAbstract.class);
	
	@Autowired
	private SYSLogService sysLogService;
	
	@RequestMapping(value = "/sysLogPage",method = RequestMethod.GET)
	public String infoList(Model model){
		return "menu/sysLog/sysLogList";
    }
	
	@RequestMapping(value = "/getList")
    @ResponseBody
    public ViewResult getIpConfList(HttpServletRequest request) throws JsonParseException, JsonMappingException, IOException {
		
		   String[] keys = {"loginName","detaTime","ip","type","pageNum","pageSize"};
	       ViewResult viewResult = new ViewResult();
	       Map<String, String[]> resParams = request.getParameterMap();
	       Map<String, Object> params = CommonUtil.getParamsByKeys(resParams, keys);
	      
	       JsonObject whiltejsonObj = sysLogService.getConfigJson(params);
	       String response = whiltejsonObj.toString();
	       
	       ObjectMapper objectMapper = new ObjectMapper();
	       HashMap<String, Object> jsonObj = objectMapper.readValue(response, HashMap.class);
	       if (jsonObj != null && (int) jsonObj.get("status") == 1) {
	           Map<String, Object> param = new HashMap<>(16);
	           param.put("data", jsonObj.get("syslog"));
	           String datas = objectMapper.writeValueAsString(param);
	
	           List<String> data = new ArrayList<>();
	           data.add(datas);
	           viewResult.setData(data);
	           viewResult.setTotalNum((int) jsonObj.get("total"));
	       } else {
	           viewResult.setStatus(ViewResult.ERROR);
	           viewResult.setError("无匹配内容");
	       }
		return viewResult;
		
    }

    @RequestMapping("testAdd")
	public void testAdd(HttpServletRequest request) {
		String loginName = request.getParameter("loginName");
		sysLogService.addTest(loginName);
	}

}


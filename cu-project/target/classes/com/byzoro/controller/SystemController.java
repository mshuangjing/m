package com.byzoro.controller;

import com.byzoro.entity.City;
import com.byzoro.entity.SYSUser;
import com.byzoro.entity.SessionInfo;
import com.byzoro.service.CityService;
import com.byzoro.service.SYSLogService;
import com.byzoro.service.SysRoleService;
import com.byzoro.service.SysUserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.byzoro.utils.CommonUtil;
import com.byzoro.utils.MD5Util;
import com.byzoro.utils.PasswordUtil;
import com.byzoro.utils.ViewResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.alibaba.fastjson.JSONObject;
//import com.byzoro.entity.BasicSetting;
//import City;
//import com.byzoro.entity.DeviceGroup;
//import com.byzoro.service.BasicSettingService;

@Controller
@RequestMapping("/system")
public class SystemController {

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private CityService cityService;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
    private SYSLogService sysLogService;

    ObjectMapper mapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
	/**
	 * 跳转到用户管理界面
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model){
		//查询除admin外的所有的角色名称
		List<Map<String, Object>> sysRoleList = sysRoleService.getSysRoleListNotAdmin();
		model.addAttribute("sysRoleList", sysRoleList);
		//查询所有的省级名称
		List<City> cities = cityService.queryByParentId(1);
		model.addAttribute("cities", cities);
		return "index/systemManagement/userManagement";
	}

	/**
	 * 查询全部的用户组
	 * @return
	 */
	@RequestMapping("queryAllRole")
	@ResponseBody
	public ViewResult queryAllRole(){
		ViewResult viewResult = new ViewResult();
		//查询除admin外的所有的角色名称
		List<Map<String, Object>> sysRoleList = sysRoleService.getSysRoleListNotAdmin();
		viewResult.setData(sysRoleList);
		return viewResult;
	}

	/**
	 * 分页查询用户管理数据
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ViewResult getList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		String[] keys = { "roleId", "uname","userType", "pagenum",  "pageSize","order", "sort" };
		Map<String, String[]> resParams = request.getParameterMap();
		Map<String, Object> params = CommonUtil.getParamsByKeys(resParams, keys);
		List<Map<String, Object>> sysUserList = null;
        // 总数
		int countNew;
		//跳过查询管理员
		params.put("FlagInfo", 1);
        sysUserList = sysUserService.getSYSUserListNew(params);
        countNew = sysUserService.getCountNew(params);
		ViewResult viewResult = new ViewResult();
		viewResult.setData(sysUserList);
		viewResult.setTotalNum(countNew);

		return viewResult;
	}

	/**
	 * 新增用户信息
	 * @param sysUser
	 * @return
	 */
	@PostMapping(value = "/addUserInfo")
	@ResponseBody
	public ViewResult addUserInfo(SYSUser sysUser) throws JsonProcessingException {
		ViewResult viewResult = new ViewResult();
		try {
			boolean checkedStatus = sysUserService.checkName(sysUser.getUname());
			if (checkedStatus) {
				sysUser.setPwd(PasswordUtil.encryptPassword(sysUser.getPwd()));
				if (StringUtils.isNotEmpty(sysUser.getMapLat())) {
					sysUser.setMapLat(String.format("%.6f", Double.parseDouble(sysUser.getMapLat())));
				}
				if (StringUtils.isNotEmpty(sysUser.getMapLng())) {
					sysUser.setMapLng(String.format("%.6f", Double.parseDouble(sysUser.getMapLng())));
				}
				int i = sysUserService.insertUser(sysUser);
				if (i <= 0) {
					viewResult.setInfo("增加失败");
					viewResult.setStatus(ViewResult.ERROR);
				}
			} else {
				viewResult.setStatus(ViewResult.ERROR);
				viewResult.setInfo("增加失败，已存在账号："+sysUser.getUname());
			}

		} catch (Exception e) {
			e.printStackTrace();
			viewResult.setStatus(ViewResult.ERROR);
			viewResult.setInfo("增加失败");
		}

        String adds = mapper.writeValueAsString(sysUser);
		sysLogService.insertSyslog("用户管理新增","",adds,"2",sysUser.getUname());
		return viewResult;
	}

	/**
	 * 根据id查询用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/queryById/{id}")
	@ResponseBody
	public ViewResult queryById(@PathVariable Integer id) {
		ViewResult viewResult = new ViewResult();
		SYSUser sysUser = sysUserService.selectByPrimaryKey(id.longValue());
		viewResult.setObj(sysUser);
//        String s = mapper.writeValueAsString(sysUser);
//        sysLogService.insertSyslog("用户管理查看详情","",s,"4",sysUser.getUname());
		return viewResult;
	}

	/**
	 * 通过id修改用户信息
	 * @param sysUser
	 * @return
	 */
	@PostMapping("editUserById")
	@ResponseBody
	public ViewResult editUserById(SYSUser sysUser) throws JsonProcessingException {
		ViewResult viewResult = new ViewResult();
		try {
			if (StringUtils.isNotEmpty(sysUser.getMapLat())) {
				sysUser.setMapLat(String.format("%.6f", Double.parseDouble(sysUser.getMapLat())));
			}
			if (StringUtils.isNotEmpty(sysUser.getMapLng())) {
				sysUser.setMapLng(String.format("%.6f", Double.parseDouble(sysUser.getMapLng())));
			}
			int i = sysUserService.updateByPrimaryKeySelective(sysUser);
			if (i <= 0) {
				viewResult.setStatus(ViewResult.ERROR);
				viewResult.setInfo("编辑失败");
			}
			String s = mapper.writeValueAsString(sysUser);
			sysLogService.insertSyslog("用户管理修改","",s,"3",sysUser.getUname());
		} catch (Exception e) {
			viewResult.setStatus(ViewResult.ERROR);
			viewResult.setInfo("编辑失败");
			e.printStackTrace();
		}
		return viewResult;
	}

	/**
	 * 通过id删除用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteUser/{id}")
	@ResponseBody
	public ViewResult deleteUser(@PathVariable Integer id) throws JsonProcessingException {
		SessionInfo info = (SessionInfo)SecurityUtils.getSubject().getPrincipal();
		ViewResult viewResult = new ViewResult();
        SYSUser sysUser = sysUserService.selectByPrimaryKey(id.longValue());
        String s = mapper.writeValueAsString(sysUser);
        sysLogService.insertSyslog("用户管理删除","",s,"1",sysUser.getUname());
        if(id.longValue() == info.getUserId()){
            //不能删除自己
            viewResult.setStatus(ViewResult.ERROR);
            viewResult.setInfo("不能删除当前登录用户");
        }else{
            int i = sysUserService.deleteByPrimaryKey(id.longValue());
            if (i <= 0) {
                viewResult.setStatus(ViewResult.ERROR);
                viewResult.setInfo("删除失败");
            }
        }
		return viewResult;
	}

	//批量删除用户信息
    /**
     * 通过id重置密码
     * @return
     */
	@RequestMapping("resetPassword")
    @ResponseBody
    public ViewResult resetPassword(HttpServletRequest request) throws JsonProcessingException {
		ViewResult viewResult = null;
		try {
			String userId = request.getParameter("userId");
			String pwd = request.getParameter("pwd");
			//页面传入原密码
            String originpwd = request.getParameter("originpwd");
            viewResult = new ViewResult();
			//重置密码 判断原密码是否错误
            SYSUser sysUser = sysUserService.selectByPrimaryKey(Long.valueOf(userId));
            String oldPwd = sysUser.getPwd();
//            oldPwd= oldPwd.substring(oldPwd.length()-6);
            String newPwd = PasswordUtil.encryptPassword(originpwd, oldPwd.substring(0, 16));
            if(!oldPwd.equals(newPwd)){
                viewResult.setStatus(ViewResult.ERROR);
                viewResult.setInfo("原密码输入错误!");
            }
            sysUser.getPwd();
            int i = sysUserService.resetPwd(PasswordUtil.encryptPassword(pwd),userId);
			//重置失败
			if (i<=0) {
				viewResult.setStatus(ViewResult.ERROR);
			}
			sysLogService.insertSyslog("用户管理密码重置","",null,"3","");
		} catch (Exception e) {
			viewResult.setStatus(ViewResult.ERROR);
			e.printStackTrace();
		}
		return viewResult;
    }

	@RequestMapping(value = "/deleteUserByIds")
	@ResponseBody
	public ViewResult deleteUserByIds(String ids) throws JsonProcessingException {
		ViewResult viewResult = new ViewResult();
		//记录删除成功的次数
		int successNum = 0;
		//记录删除是否有admin用户
		int adminNum = 0;
		//记录是否有用户自己
		int self = 0;
		SessionInfo info = (SessionInfo)SecurityUtils.getSubject().getPrincipal();
		String[] split = ids.split(",");
		for(int i=0;i<split.length;i++){
			//string转换int
			long id = Long.parseLong(split[i]);
			if(id==1){
				adminNum ++;
				continue;
			}else if(id == info.getUserId()){
				self ++;
			}else{
                SYSUser sysUser =sysUserService.selectByPrimaryKey(id);
                String s = mapper.writeValueAsString(sysUser);
                sysLogService.insertSyslog("用户管理批量删除",s,"","1",sysUser.getUname());
                int delNum = sysUserService.deleteByPrimaryKey(id);
                if (delNum>0) {
                    successNum ++;
                }
			}
		}
		StringBuilder infoBuilder = new StringBuilder();
		if (adminNum > 0) {
			infoBuilder.append("不能删除管理员</br>");
			viewResult.setStatus(ViewResult.ERROR);
		}
		if (self > 0) {
			infoBuilder.append("不能删除当前登录用户</br>");
			viewResult.setStatus(ViewResult.ERROR);
		}
		if (successNum > 0) {
			infoBuilder.append("成功删除").append(successNum).append("条数据</br>");
		}
		if ((split.length - successNum) > 0) {
			infoBuilder.append("有").append(split.length - successNum).append("条数据删除失败");
			viewResult.setStatus(ViewResult.ERROR);
		}
		viewResult.setInfo(infoBuilder.toString());
		return viewResult;
	}

	//判断用户新密码与原密码是否一致
	@RequestMapping("getPwd")
    @ResponseBody
	public Map<String,Object> getInterfByProco(HttpServletRequest request)  {
		Map<String,Object> map = new HashMap<String,Object>(); 
		String[] keys = { "pwd", "userId"};
		Map<String, String[]> resParams = request.getParameterMap();
		Map<String, Object> params = CommonUtil.getParamsByKeys(resParams, keys);
		 SYSUser sysUser = sysUserService.selectByPrimaryKey(Long.parseLong(params.get("userId").toString()));
		if(sysUser.getPwd().equals(MD5Util.getMd5(params.get("pwd").toString()))){
			map.put("flag","true");
		}else{
			map.put("flag","false");
		}
		return map;
	}

	@RequestMapping("oneLogin")
	public String oneLogin(HttpServletRequest request)  {
		SessionInfo info = (SessionInfo)SecurityUtils.getSubject().getPrincipal();//当前登录的用户
		
		SYSUser sysUser = sysUserService.getUserByPrimaryKey(info.getUserId());
		//if("".equals(sysUser.getLastTime())||null==sysUser.getLastTime()){
		//	return "redirect:/system/setPasswordOne/"+sysUser.getUserId();
		//}else{
			return "redirect:/user/loginSuccess";
		//}
	}
	
	
	
	/**
	 * 验证用户名 
	 * @return
	 *//*
	@RequestMapping(value = "/checkUserName/{uname}" )
	@ResponseBody
	public Map<String,Object> checkUserName(@PathVariable String uname){
		Map<String,Object> map = new HashMap<String,Object>();
			if (userService.checkName(uname)) {
				map.put("flag","true");
			}else {
				map.put("flag","false");
			
		}
			return map;
	}*/
	
/*	@RequestMapping(value = "/resetPwd/{id}")
	@ResponseBody
	public ViewResult resetPwd(@PathVariable Integer id) {
		
		SYSUser sysUser = new SYSUser();
		sysUser.setPwd(MD5Util.getMd5("123456"));
		sysUser.setUserId(id.longValue());
		userService.updateUserByPwd1(sysUser);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", 0);
		map.put("user_id", id);
		userService.updateWhiteState(map);
		return new ViewResult();
	}*/
	
	
/*	@RequestMapping("configuration")
	public String configuration(Model model){
		BasicSetting basicSetting = basicSettingService.selectByPrimaryKey(1);
		model.addAttribute("basicSetting", basicSetting);
		return "menu/system/configuration";
	}*/
	
	
/*	@RequestMapping(value = "/editBasicSetting", method = RequestMethod.POST)
	@ResponseBody
	public ViewResult editBasicSetting(BasicSetting basicSetting) {
		ViewResult viewResult = new ViewResult();
		Map<String, Object> basicData = basicSettingService.getUpdateBeforeData(basicSetting.getId());
		JSONObject jsonObject = new JSONObject(basicData);
		String dataBeforeOperation = jsonObject+"";
		basicSettingService.updateByPrimaryKeySelective(basicSetting);
		Map<String, Object> basicDataTwo = basicSettingService.getUpdateBeforeData(basicSetting.getId());
		JSONObject afterJsonObject = new JSONObject(basicDataTwo);
		String dataAfterOperation = afterJsonObject+"";
		sysLogService.addAllSysLogInfo("编辑基础配置", dataBeforeOperation, dataAfterOperation);
		return viewResult;
	}*/
	
	
	
	@RequestMapping("hardFullAlarmLog")
	public String hardFullAlarmLog(Model model){

		return "menu/system/hardFullAlarmLog";
	}

	@RequestMapping("basicSettingDelete")
	public String hardDataDeleteLog(Model model){

		return "menu/system/hardDataDeleteLog";
	}
}

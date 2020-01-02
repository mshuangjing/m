package com.byzoro.controller;

import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSUser;
import com.byzoro.service.SYSLogService;
import com.byzoro.service.SysRoleService;
import com.byzoro.service.SysUserService;
import com.byzoro.utils.CommonUtil;
import com.byzoro.utils.SysLogCodeConstant;
import com.byzoro.utils.ViewResult;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户组控制层
 * @author liwenhui
 */
@Controller
@RequestMapping("/systemGroup")
public class SystemGroupController {
	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private SYSLogService sysLogService;

	/**
	 * 跳转到用户组页面
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model) {
		return "index/systemManagement/usergroupmana";
	}

	/**
	 * 分页查询用户组数据
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ViewResult getList(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws IOException {
		String[] keys = { "roleName", "pagenum", "pageSize", "order", "sort" };
		Map<String, String[]> resParams = request.getParameterMap();
		Map<String, Object> params = CommonUtil.getParamsByKeys(resParams, keys);
		params.put("roleId", 1);
		int selectTotalNumber = sysRoleService.selectTotalNumber(params);
		List<Map<String, Object>> sysRoleList = sysRoleService.getSYSRoleList(params);
		ViewResult viewResult = new ViewResult();
		viewResult.setData(sysRoleList);
		viewResult.setTotalNum(selectTotalNumber);

		return viewResult;
	}

	/**
	 *  增加角色
	 * @param sYSRole
	 * @return
	 */
	@RequestMapping(value = "/addRoleInfo", method = RequestMethod.POST)
	@ResponseBody
	public ViewResult addHouseConfigPost(SYSRole sYSRole) {
		ViewResult viewResult = new ViewResult();
        if (sysRoleService.checkName(sYSRole.getRoleName())) {
            int i = sysRoleService.insertSelective(sYSRole);
			if (i <= 0) {
				viewResult.setStatus(ViewResult.ERROR);
				viewResult.setInfo("增加失败");
			} else {
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
					String afterJson = objectMapper.writeValueAsString(sYSRole);
					sysLogService.insertSyslog("新增用户组", null, afterJson, SysLogCodeConstant.INSERT,sYSRole.getRoleName());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
        } else {
            viewResult.setStatus(ViewResult.ERROR);
            viewResult.setInfo("增加失败,已存在相同的用户组："+sYSRole.getRoleName());
        }
		return viewResult;
	}

	/**
	 * 通过id查询角色
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryById/{id}")
	@ResponseBody
	public ViewResult queryById(@PathVariable Integer id, Model model) {
		ViewResult viewResult = new ViewResult();
		SYSRole sysRole = sysRoleService.selectByPrimaryKey(id.longValue());
		viewResult.setObj(sysRole);
		return viewResult;
	}

	/**
	 * 编辑角色
	 * @param sYSRole
	 * @return
	 */
	@RequestMapping(value = "/editRoleUpdate", method = RequestMethod.POST)
	@ResponseBody
	public ViewResult updateKpiBaseStatic(SYSRole sYSRole) {
		ViewResult viewResult = new ViewResult();
		SYSRole sysRole = sysRoleService.selectByPrimaryKey(sYSRole.getRoleId().longValue());
		if (sYSRole != null) {
			//判断是否修改了用户组名称
			if (!sysRole.getRoleName().equals(sYSRole.getRoleName())) {
				//判断是否有重名
				if (!sysRoleService.checkName(sYSRole.getRoleName())) {
					viewResult.setStatus(ViewResult.ERROR);
					viewResult.setInfo("修改失败,已存在相同的用户组："+sYSRole.getRoleName());
					return viewResult;
				}
			}
			SYSRole BeforeSysRole = sysRoleService.selectByPrimaryKey(sYSRole.getRoleId());
			int i = sysRoleService.updateByPrimaryKeySelective(sYSRole);
			if (i <= 0) {
				viewResult.setStatus(ViewResult.ERROR);
				viewResult.setInfo("修改失败");
			} else {
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
					String beforeJson = objectMapper.writeValueAsString(BeforeSysRole);
					String afterJson = objectMapper.writeValueAsString(sYSRole);
					sysLogService.insertSyslog("编辑用户组", beforeJson, afterJson, SysLogCodeConstant.UPDATE,sYSRole.getRoleName());
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}else {
			viewResult.setStatus(ViewResult.ERROR);
			viewResult.setInfo("数据异常,修改失败");
		}

		return viewResult;
	}

	/**
	 * 根据id删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteRole/{id}")
	@ResponseBody
	public ViewResult delKpiBaseStaticById(@PathVariable Integer id) {
		ViewResult viewResult = new ViewResult();
		List<SYSUser> sysUsers = sysUserService.queryUserByRoleId(id.longValue());
		if (sysUsers.size()<=0) {
			SYSRole sysRole = sysRoleService.selectByPrimaryKey(id.longValue());
			int i = sysRoleService.deleteByPrimaryKey(id.longValue());
			if (i <= 0) {
				viewResult.setStatus(ViewResult.ERROR);
				viewResult.setInfo("删除失败,系统异常");
			} else {
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
					String afterJson = objectMapper.writeValueAsString(sysRole);
					sysLogService.insertSyslog("删除用户组", null, afterJson, SysLogCodeConstant.DELETE,"");
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}
		}else {
			viewResult.setData(sysUsers);
			viewResult.setStatus(ViewResult.ERROR);
			viewResult.setInfo("删除失败,与用户存在依赖关系");
		}
		return viewResult;
	}

	/**
	 * 根据ids批量删除用户角色
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deleteRoleByIds")
	@ResponseBody
	public ViewResult deleteRoleByIds(String ids) {
		ViewResult viewResult=new ViewResult();
		StringBuilder infoBuilder = new StringBuilder();
		// 记录删除成功的次数
		int successNum = 0;
		String[] split = ids.split(",");
		int total=split.length;
		for (int i = 0; i < split.length; i++) {
			// string转换long
			long id = Long.parseLong(split[i]);
			List<SYSUser> sysUsers = sysUserService.queryUserByRoleId(id);
			//判断是否存在依赖关系
			if (sysUsers.size()<=0) {
				SYSRole sysRole = sysRoleService.selectByPrimaryKey(id);
				int delNum = sysRoleService.deleteByPrimaryKey(id);
				if (delNum > 0) {
					successNum++;
					try {
						ObjectMapper objectMapper = new ObjectMapper();
						objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
						String afterJson = objectMapper.writeValueAsString(sysRole);
						sysLogService.insertSyslog("删除用户组", null, afterJson, SysLogCodeConstant.DELETE,sysRole.getRoleName());
					} catch (JsonProcessingException e) {
						e.printStackTrace();
					}
				}
			}else {

			}
		}
		if (successNum > 0) {
			infoBuilder.append("成功删除").append(successNum).append("条数据");
			if ((total - successNum) > 0) {
				infoBuilder.append("</br>有").append(total - successNum).append("条数据存在依赖关系删除失败");
				viewResult.setStatus(ViewResult.ERROR);
			}
		} else {
			infoBuilder.append("有").append(total - successNum).append("条数据存在依赖关系删除失败");
			viewResult.setStatus(ViewResult.ERROR);
		}
		viewResult.setInfo(infoBuilder.toString());
		return viewResult;
	}

	/**
	 * 验证是否绑定相同角色
	 *
	 * @param roleName
	 * @return
	 */
	@RequestMapping(value = "/checkRoleName/{roleName}")
	@ResponseBody
	public Map<String, Object> checkUserName(@PathVariable String roleName) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (sysRoleService.checkName(roleName)) {
			map.put("flag", "true");
		} else {
			map.put("flag", "false");
		}
		return map;
	}

	/**
	 * 通过角色id查询用户角色关联信息
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getSysUserRoleByRoleId/{id}")
	@ResponseBody
	public ViewResult getSysUserRoleByRoleId(@PathVariable int id) {
		ViewResult viewResult = new ViewResult();
		Map<String, Object> params = new HashMap<>();
		params.put("roleId", id);
		List<Map<String, Object>> sysUserRoleByRoleList = sysRoleService.getSysUserRoleByRole(params);
		if (null == sysUserRoleByRoleList || sysUserRoleByRoleList.size() == 0) {
			return viewResult;
		} else {
			viewResult.setStatus(ViewResult.ERROR);
			viewResult.setInfo(String.valueOf(sysUserRoleByRoleList.size()));
			return viewResult;
		}
	}
}

package com.byzoro.controller;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.ZTreeModel;
import com.byzoro.service.SYSResourceService;
import com.byzoro.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.regex.Pattern;

/**
 * @author MSJ
 */
@Controller
@RequestMapping("resource")
public class SysResourceControllerAbstract {

	@Autowired
	private SYSResourceService resourceService;
	
	//修改资源
	@RequestMapping("modifyResource")
	@ResponseBody
	public Map<String,Object> modifyResource(HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String,Object>(16);
		String resourceName = request.getParameter("resource_name");
		String resourceHref = request.getParameter("resource_href");
		String resourceDesc = request.getParameter("resource_desc");
		String resourceType = request.getParameter("resource_type");
		String resourceRemark = request.getParameter("resource_remark");
		String sortIndex = request.getParameter("sort_index");
		String parentId = request.getParameter("parent_id");
		String isLeaf = request.getParameter("is_leaf");
		String tempOne = request.getParameter("temp_one");
		String resourceId = request.getParameter("resource_id");
		
		String regEx="[A-Z,a-z,/]+";

		boolean flag=Pattern.compile(regEx).matcher(resourceHref).matches();
		
		if(!flag){
			result.put("success", true);
			result.put("message", "修改失败！资源链接只能包含字母和斜线！");
			return result;
		}
		
		SYSResource resource = resourceService.selectByPrimaryKey(Integer.parseInt(resourceId));
		
		resource.setResourceName(resourceName);
		resource.setResourceHref(resourceHref);
		resource.setResourceDesc(resourceDesc);
		resource.setResourceType(resourceType);
		resource.setResourceRemark(resourceRemark);
		resource.setSortIndex(Integer.parseInt(sortIndex));
		resource.setParentId(Integer.parseInt(parentId));
		resource.setIsLeaf(isLeaf);
		resource.setTempOne(tempOne);
		resource.setCreateTime(null);
		resourceService.updateByPrimaryKeySelective(resource);
		
		result.put("success", true);
		result.put("message", "修改资源成功！");
		return result;
	}
	
	//添加资源
	@RequestMapping("addResource")
	@ResponseBody
	public Map<String,Object> addResource(HttpServletRequest request){
		
		Map<String,Object> result = new HashMap<String,Object>(16);
		String resourceName = request.getParameter("resource_name");
		String resourceHref = request.getParameter("resource_href");
		String resourceDesc = request.getParameter("resource_desc");
		String resourceType = request.getParameter("resource_type");
		String resourceRemark = request.getParameter("resource_remark");
		String sortIndex = request.getParameter("sort_index");
		String parentId = request.getParameter("parent_id");
		String isLeaf = request.getParameter("is_leaf");
		String tempOne = request.getParameter("temp_one");
		
		String regEx="[A-Z,a-z,/]+";

		boolean flag=Pattern.compile(regEx).matcher(resourceHref).matches();
		
		if(!flag){
			result.put("success", true);
			result.put("message", "增加失败！资源链接只能包含字母和斜线！");
			return result;
		}
		
		SYSResource resource = new SYSResource();
		resource.setResourceName(resourceName);
		resource.setResourceHref(resourceHref);
		resource.setResourceDesc(resourceDesc);
		resource.setResourceType(resourceType);
		resource.setResourceRemark(resourceRemark);
		resource.setSortIndex(Integer.parseInt(sortIndex));
		resource.setParentId(Integer.parseInt(parentId));
		resource.setIsLeaf(isLeaf);
		resource.setTempOne(tempOne);
		resource.setCreateTime(new Date());
		
		resourceService.insertSelective(resource);
		
		result.put("success", true);
		result.put("message", "增加资源成功！");
		return result;
	}
	
	@RequestMapping("goResourceList")
	public String goResourceList(HttpServletRequest request){
		request.setAttribute("resourceList", resourceService.getAllParentResource());
		return "menu/resource/resourceList";
	}
	//查询
	@RequestMapping(value="resourceList")
	@ResponseBody
	public Map<String,Object> resourcesList(HttpServletRequest request){
			
			String r = request.getParameter("rows");
			String p = request.getParameter("page");
			//模糊查询
			String resourceName = request.getParameter("resource_name");
			String resourceHref = request.getParameter("resource_href");
			String resourceDesc = request.getParameter("resource_desc");
			//非模糊
			String resourceType = request.getParameter("resource_type");
			
			Map<String,Object> result = new HashMap<String,Object>(16);
			HashMap<String,Object> params = new HashMap<String,Object>(16);

			if ("".equals(resourceName) || resourceName == null) {
				params.put("resource_name", "");
			} else {
				params.put("resource_name", "%"+resourceName+"%");
			}
			if ("".equals(resourceHref) || resourceHref == null) {
				params.put("resource_href", "");
			} else {
				params.put("resource_href", "%"+resourceHref+"%");
			}
			if ("".equals(resourceDesc) || resourceDesc == null) {
				params.put("resource_desc", "");
			} else {
				params.put("resource_desc", "%"+resourceDesc+"%");
			}
			params.put("resource_type", resourceType);
			
			
			long count = resourceService.getCount(params);
			PageUtil page = new PageUtil(Integer.parseInt(r),(int)resourceService.getCount(params),Integer.parseInt(p));
			params.put("page", page.getFromIndex());
			params.put("row", page.getPageSize());
			List<Map<String,Object>> newList = resourceService.getSYSResourceList(params);
			result.put("total", count);
			result.put("rows", newList);

			return result;
		}
	
		//获取菜单树数据源
		@ResponseBody
		@RequestMapping(value="getResourceZTree")
		public Map<String,Object> getResourceZTree(HttpServletRequest request){
			Map<String,Object> result = new HashMap<String,Object>(16);
			
			List<ZTreeModel> list = resourceService.getZtreeResourceTree();
			List<ZTreeModel> checkList = new ArrayList<ZTreeModel>();
			List<Map<String,Object>> resourceList = new ArrayList<Map<String,Object>>();
			String roleId = request.getParameter("roleId");
			String userId = request.getParameter("userId");
			if(null!=roleId){
				resourceList = resourceService.getResourceIdsByRoleId(roleId);
			}
			
			if(null!=userId){
				resourceList = resourceService.getResourceIdsByUserId(userId);
			}
			checkList = resourceService.checkResourceByAlreadyHasResourceList(list,resourceList);
			
			result.put("success", true);
			result.put("data", checkList);
			result.put("msg", "查询成功");
			return result;
		}
}

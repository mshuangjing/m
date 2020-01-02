package com.byzoro.service.impl;

import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSRoleResource;
import com.byzoro.entity.SYSUserRole;
import com.byzoro.mapper.SYSRoleMapper;
import com.byzoro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SYSRoleMapper sysRoleMapper;
	@Override
	public int deleteByPrimaryKey(Long roleId) {
		return sysRoleMapper.deleteByPrimaryKey(roleId);
	}

	@Override
	public int insert(SYSRole record) {
		return sysRoleMapper.insert(record);
	}

	@Override
	public int insertSelective(SYSRole record) {
		return sysRoleMapper.insertSelective(record);
	}

	@Override
	public SYSRole selectByPrimaryKey(Long roleId) {
		return sysRoleMapper.selectByPrimaryKey(roleId);
	}

	@Override
	public int updateByPrimaryKeySelective(SYSRole record) {
		return sysRoleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SYSRole record) {
		return sysRoleMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Map<String, Object>> getSYSRoleList(Map<String,Object> params) {
		params.put("pageSize", Integer.parseInt((String) params.get("pageSize")));
		params.put("pageCurr", (Integer.parseInt((String) params.get("pagenum")) - 1) * (Integer)params.get("pageSize"));
		return sysRoleMapper.getSYSRoleList(params);
	}

	@Override
	public long getCount() {
		return sysRoleMapper.getCount();
	}

	@Override
	public int deleteResourceByRoldId(String roleId) {
		return sysRoleMapper.deleteResourceByRoldId(roleId);
	}

	@Override
	public int insertRelationOfRoleAndResource(String roleId, String ids) {
		List<SYSRoleResource> list = new ArrayList<SYSRoleResource>();
		String[] joinIds = ids.split(",");
		for(int i=0;i<joinIds.length;i++){
			SYSRoleResource model = new SYSRoleResource();
			model.setRoleId(Integer.parseInt(roleId));
			model.setResourceId(Integer.parseInt(joinIds[i]));
			list.add(model);
		}
		return sysRoleMapper.insertRelationOfRoleAndResource(list);
	}

	@Override
	public List<Map<String, Object>> getUserRoleInfo(Integer userId) {
		return sysRoleMapper.getUserRoleInfo(userId);
	}

	@Override
	public int deleteRoleByUserId(int userId) {
		return sysRoleMapper.deleteRoleByUserId(userId);
	}

	/**
	 * 角色授权
	 */
	@Override
	public int insertRoleByUserId(int userId,String roles) {
		SYSUserRole ur = null;
		List<SYSUserRole> list = new ArrayList<SYSUserRole>();
		String[] role = roles.split(",");
		for (String r : role) {
			ur = new SYSUserRole();
			ur.setUserId((long)userId);
			ur.setRoleId(Long.valueOf(r));
			list.add(ur);
		}
		return sysRoleMapper.insertRoleByUserId(list);
	}

	@Override
	public int selectTotalNumber(Map<String, Object> params) {
		return sysRoleMapper.selectTotalNumber(params);
	}

	@Override
	public boolean checkName(String name) {
        List<SYSRole> roleList = new ArrayList<>();
		try {
			roleList = sysRoleMapper.getRoleByName(name);
		} catch (Exception e) {
		    e.printStackTrace();
		}
		if (roleList.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public List<Map<String, Object>> getSysUserRoleByRole(Map<String, Object> params) {
		return sysRoleMapper.getSysUserRoleByRole(params);
	}

	@Override
	public List<Map<String, Object>> getSysRoleListNotAdmin() {
		return sysRoleMapper.getSysRoleListNotAdmin();
	}

}

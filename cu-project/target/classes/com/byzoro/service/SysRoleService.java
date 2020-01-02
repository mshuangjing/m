package com.byzoro.service;

import com.byzoro.entity.SYSRole;

import java.util.List;
import java.util.Map;


public interface SysRoleService {

	int deleteByPrimaryKey(Long roleId);

    int insert(SYSRole record);

    int insertSelective(SYSRole record);

    SYSRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SYSRole record);

    int updateByPrimaryKey(SYSRole record);
    
    List<Map<String,Object>> getSYSRoleList(Map<String, Object> params);

    long getCount();

    int deleteResourceByRoldId(String roleId);

    int insertRelationOfRoleAndResource(String roleId, String ids);

    List<Map<String, Object>> getUserRoleInfo(Integer userId);

    int deleteRoleByUserId(int userId);

    int insertRoleByUserId(int userId, String roles);

    /**
     * 查询总条数
     * @param params
     * @return
     */
    int selectTotalNumber(Map<String, Object> params);

    /**
     * 检查名称角色
     * @param name
     * @return
     */
    boolean checkName(String name);

    /**
     * 通过角色id查询用户角色关联信息
     * @param params
     * @return
     */
    List<Map<String, Object>> getSysUserRoleByRole(Map<String, Object> params);

    /**
     * 查询除了系统管理员之外的角色列表
     * @return
     */
    List<Map<String, Object>> getSysRoleListNotAdmin();
}

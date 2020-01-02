package com.byzoro.mapper;

import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSRoleResource;
import com.byzoro.entity.SYSUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SYSRoleMapper {
    int deleteByPrimaryKey(Long roleId);

    int insert(SYSRole record);

    int insertSelective(SYSRole record);

    SYSRole selectByPrimaryKey(Long roleId);

    int updateByPrimaryKeySelective(SYSRole record);

    int updateByPrimaryKey(SYSRole record);
    
    List<Map<String,Object>> getSYSRoleList(Map<String, Object> params);
    
    long getCount();
    
    int deleteResourceByRoldId(String roleId);

	int insertRelationOfRoleAndResource(List<SYSRoleResource> list);
	
	List<Map<String, Object>> getUserRoleInfo(Integer userId);
	
	int deleteRoleByUserId(int userId);
	
	int insertRoleByUserId(List<SYSUserRole> list);

    /**
     * 查询总数
     * @param params
     * @return
     */
    int selectTotalNumber(Map<String, Object> params);

    /**
     * 通过名称查询角色
     * @param name
     * @return
     */
    List<SYSRole> getRoleByName(String name);

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
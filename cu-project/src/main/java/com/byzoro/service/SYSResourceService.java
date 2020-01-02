package com.byzoro.service;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.ZTreeModel;

import java.util.List;
import java.util.Map;


public interface SYSResourceService {
	int deleteByPrimaryKey(Integer id);

    int insert(SYSResource record);

    int insertSelective(SYSResource record);

    SYSResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SYSResource record);

    int updateByPrimaryKey(SYSResource record);
    
    List<SYSResource> getResourceByRoleId(Long roleId);
    
    List<SYSResource> dealAllResource(
            List<SYSResource> resourceList);

    List<Map<String,Object>> getSYSResourceList(Map<String, Object> params);

    long getCount(Map<String, Object> params);

    List<Map<String,Object>> getAllParentResource();

    List<ZTreeModel>getZtreeResourceTree();

    List<Map<String,Object>> getResourceIdsByRoleId(String roleId);

    public List<ZTreeModel> checkResourceByAlreadyHasResourceList(
            List<ZTreeModel> list, List<Map<String, Object>> resourceList);
    
    List<Map<String,Object>> getResourceIdsByUserId(String userId);
    
    List<SYSResource> getAllResource();
}

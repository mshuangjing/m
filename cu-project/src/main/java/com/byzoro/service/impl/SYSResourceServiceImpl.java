package com.byzoro.service.impl;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.ZTreeModel;
import com.byzoro.mapper.SYSResourceMapper;
import com.byzoro.service.SYSResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SYSResourceServiceImpl implements SYSResourceService {

	@Autowired
	private SYSResourceMapper resourceDAO;

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return resourceDAO.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SYSResource record) {
		return resourceDAO.insert(record);
	}

	@Override
	public int insertSelective(SYSResource record) {
		return resourceDAO.insertSelective(record);
	}

	@Override
	public SYSResource selectByPrimaryKey(Integer id) {
		return resourceDAO.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(SYSResource record) {
		return resourceDAO.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SYSResource record) {
		return resourceDAO.updateByPrimaryKey(record);
	}

	@Override
	public List<SYSResource> getResourceByRoleId(Long roleId) {
		return resourceDAO.getResourceByRoleId(roleId);
	}

	@Override
	public List<SYSResource> dealAllResource(List<SYSResource> resourceList) {
		List<SYSResource> bigList = new ArrayList<SYSResource>();
		List<SYSResource> rootList = new ArrayList<SYSResource>();
		// 获取根节点 的list
		for (SYSResource map : resourceList) {
			if ((Integer) map.getParentId() == 0) {
				rootList.add(map);
			}
		}
		for (SYSResource rootMap : rootList) {
			List<SYSResource> sonList = new ArrayList<SYSResource>();
			for (SYSResource map : resourceList) {
				Integer rootId = (Integer) rootMap.getResourceId();
				Integer parentId = (Integer) map.getParentId();
				if (null != parentId && (parentId - rootId) == 0) {

					List<SYSResource> sonListSon = new ArrayList<SYSResource>();
					for (SYSResource mapSon : resourceList) {

						Integer rootIdSon = (Integer) map.getResourceId();
						Integer parentIdSon = (Integer) mapSon.getParentId();
						if (null != parentIdSon && (parentIdSon - rootIdSon) == 0) {
							
							List<SYSResource> grandSonListSon = new ArrayList<SYSResource>();
							for (SYSResource mapGrandSon : resourceList) {

								Integer rootIdGrandSon = (Integer) mapSon.getResourceId();
								Integer parentIdGrandSon = (Integer) mapGrandSon.getParentId();
								if (null != parentIdGrandSon && (parentIdGrandSon - rootIdGrandSon) == 0) {
									grandSonListSon.add(mapGrandSon);
								}

							}
							mapSon.setChildList(grandSonListSon);
							sonListSon.add(mapSon);
						}

					}
					map.setChildList(sonListSon);
					sonList.add(map);
				}
			}
			rootMap.setChildList(sonList);
			bigList.add(rootMap);
		}
		return bigList;
	}

	@Override
	public List<Map<String, Object>> getSYSResourceList(
			Map<String, Object> params) {
		return resourceDAO.getSYSResourceList(params);
	}

	@Override
	public long getCount(Map<String, Object> params) {
		return resourceDAO.getCount(params);
	}

	@Override
	public List<Map<String, Object>> getAllParentResource() {
		return resourceDAO.getAllParentResource();
	}

	@Override
	public List<ZTreeModel> getZtreeResourceTree() {
		return resourceDAO.getZtreeResourceTree();
	}

	@Override
	public List<Map<String, Object>> getResourceIdsByRoleId(String roleId) {
		return resourceDAO.getResourceIdsByRoleId(roleId);
	}

	@Override
	public List<ZTreeModel> checkResourceByAlreadyHasResourceList(
			List<ZTreeModel> list, List<Map<String, Object>> resourceList) {
		List<ZTreeModel> checkList = new ArrayList<ZTreeModel>();
		if (null == resourceList || resourceList.size() == 0) {
			return list;
		} else {
			for (ZTreeModel m : list) {
				for (Map<String, Object> map : resourceList) {
					if (m.getId() == (Integer) map.get("resource_id")) {
						m.setChecked(true);
						break;
					}
				}
				checkList.add(m);
			}
		}
		return checkList;
	}

	@Override
	public List<Map<String, Object>> getResourceIdsByUserId(String userId) {
		return resourceDAO.getResourceIdsByUserId(userId);
	}

	@Override
	public List<SYSResource> getAllResource() {
		return resourceDAO.getAllResource();
	}

}

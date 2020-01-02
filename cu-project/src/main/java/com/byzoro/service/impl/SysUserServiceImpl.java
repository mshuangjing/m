package com.byzoro.service.impl;

import com.byzoro.entity.*;
import com.byzoro.mapper.SYSUserMapper;
import com.byzoro.mapper.SYSUserRoleMapper;
import com.byzoro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SYSUserMapper sysUserMapper;

    @Autowired
    private SYSUserRoleMapper sysUserRoleMapper;

    @Override
    public int deleteByPrimaryKey(Long userId) {

        return sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int insertUser(SYSUser record) throws Exception{
        int insertUserNum = sysUserMapper.insertUser(record);
        SYSUserRole sysUserRole = new SYSUserRole();
        sysUserRole.setRoleId(record.getRoleId().longValue());
        sysUserRole.setUserId(record.getUserId());
        int insertUserRoleNum = sysUserRoleMapper.insert(sysUserRole);
        if (insertUserRoleNum > 0 && insertUserNum > 0) {
            return insertUserNum;
        }
        return 0;
    }

    @Override
    public SYSUser selectByPrimaryKey(Long userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public int updateByPrimaryKeySelective(SYSUser record){
        int updateUserNum = sysUserMapper.updateByPrimaryKeySelective(record);
        sysUserRoleMapper.deleteMappingByUserId(record.getUserId());
        SYSUserRole sysUserRole = new SYSUserRole();
        sysUserRole.setRoleId(record.getRoleId().longValue());
        sysUserRole.setUserId(record.getUserId());
        int insertUserRoleNum = sysUserRoleMapper.insert(sysUserRole);
        if (insertUserRoleNum > 0 && updateUserNum > 0) {
            return updateUserNum;
        } else {
            throw new RuntimeException("修改失败");
        }
    }

    @Override
    public int updateByPrimaryKey(SYSUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Map<String, Object>> getSYSUserList(Map<String, Object> param) {
        return sysUserMapper.getSYSUserList(param);
    }

    @Override
    public int getCount(Map<String, Object> param) {
        return sysUserMapper.getCount(param);
    }

    @Override
    public SYSUser getSYSUser(Map<String, Object> param) {
        return sysUserMapper.getSYSUser(param);
    }

    @Override
    public Set<String> getRoleNames(SYSUser user) {
        Set<String> roleNames = new HashSet<String>();
        for (SYSUserRole userRole : getUserRoleList(user)) {
            roleNames.add(userRole.getRole().getRoleName());
        }
        return roleNames;
    }

    @Override
    public List<SYSRole> getRoleList(SYSUser user) {
        List<SYSRole> roleList = new ArrayList<SYSRole>();
        for (SYSUserRole userRole : getUserRoleList(user)) {
            roleList.add(userRole.getRole());
        }
        return roleList;
    }

    @Override
    public List<SYSUserRole> getUserRoleList(SYSUser user) {
        return user.getUserRoleList();
    }

    @Override
    public List<SYSResource> getUserResTreeDataByUname(String uname) {
        return sysUserMapper.getUserResTreeDataByUname(uname);
    }

    @Override
    public List<SYSRole> getRolesByUname(String uname) {
        return sysUserMapper.getRolesByUname(uname);
    }

    @Override
    public List<SYSResource> getUserResListByUname(String uname) {
        return sysUserMapper.getUserResListByUname(uname);
    }

    @Override
    public SYSUser getUserByPrimaryKey(Long userId) {
        return sysUserMapper.getUserByPrimaryKey(userId);
    }

    @Override
    public int checkUser(Map<String, Object> params) {
        return sysUserMapper.checkUser(params);
    }

    @Override
    public int deleteResourceByUserId(String userId) {
        return sysUserMapper.deleteResourceByUserId(userId);
    }

    @Override
    public int insertRelationOfUserAndResource(String userId, String ids) {
        List<SYSUserResource> list = new ArrayList<SYSUserResource>();
        String[] joinIds = ids.split(",");
        for (int i = 0; i < joinIds.length; i++) {
            SYSUserResource model = new SYSUserResource();
            model.setUserId(Integer.parseInt(userId));
            model.setResourceId(Integer.parseInt(joinIds[i]));
            list.add(model);
        }
        return sysUserMapper.insertRelationOfUserAndResource(list);
    }


    @Override
    public boolean checkName(String name) {
        List<SYSUser> userList = null;
        try {
            userList = sysUserMapper.getRecordByName(name);
        } catch (Exception e) {
        }
        if (userList.size() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int updateLoginErrorNum(Map<String, Object> params) {
        return sysUserMapper.updateLoginErrorNum(params);
    }

    @Override
    public int updateUserLock() {
        return sysUserMapper.updateUserLock();
    }

    @Override
    public int deleteUser(String userId) {
        return sysUserMapper.deleteUser(userId);
    }

    @Override
    public int updateWhiteState(Map<String, Object> map) {
        return sysUserMapper.updateWhiteState(map);
    }

    @Override
    public List<SYSUser> queryUserByRoleId(Long roleId) {
        return sysUserMapper.queryUserByRoleId(roleId);
    }

    @Override
    public List<Map<String, Object>> getSYSUserListNew(Map<String, Object> params) {
        params.put("pageSize", Integer.parseInt((String) params.get("pageSize")));
        params.put("pageCurr", (Integer.parseInt((String) params.get("pagenum")) - 1) * (Integer)params.get("pageSize"));
        return sysUserMapper.getSYSUserListNew(params);
    }

    @Override
    public int getCountNew(Map<String, Object> param) {
        return sysUserMapper.getCountNew(param);
    }

    @Override
    public int updateLastloginTimeByUserId(Long userId,String currentTime) {
        return sysUserMapper.updateLastloginTimeByUserId(userId,currentTime);
    }

    @Override
    public Integer queryWhileStateByUname(String uname) {
        return sysUserMapper.queryWhileStateByUname(uname);
    }

    @Override
    public int resetPwd(String pwd, String userId) {
        return sysUserMapper.resetPwd(pwd,userId);
    }

    @Override
    public int adminWhileState() {
        SYSUser sysUser = sysUserMapper.selectByPrimaryKey(1L);
        if(null != sysUser){
            return sysUser.getWhiteState();
        }
        //默认0关闭
        return 0;
    }
}

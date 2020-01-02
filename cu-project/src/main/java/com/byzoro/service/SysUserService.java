package com.byzoro.service;

import com.byzoro.entity.SYSResource;
import com.byzoro.entity.SYSRole;
import com.byzoro.entity.SYSUser;
import com.byzoro.entity.SYSUserRole;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface SysUserService {

    int deleteByPrimaryKey(Long userId);

    /**
     * 增加用户
     * @param record
     * @return
     */
    int insertUser(SYSUser record) throws Exception;

    /**
     * 通过id查询用户信息
     * @param userId
     * @return
     */
    SYSUser selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SYSUser record)throws Exception;

    int updateByPrimaryKey(SYSUser record);

    SYSUser getUserByPrimaryKey(Long userId);

    List<Map<String, Object>> getSYSUserList(Map<String, Object> param);

    int getCount(Map<String, Object> param);

    SYSUser getSYSUser(Map<String, Object> param);

    Set<String> getRoleNames(SYSUser user);

    List<SYSRole> getRoleList(SYSUser user);

    List<SYSUserRole> getUserRoleList(SYSUser user);

    List<SYSResource> getUserResTreeDataByUname(String uname);

    List<SYSRole> getRolesByUname(String uname);

    List<SYSResource> getUserResListByUname(String uname);

    int checkUser(Map<String, Object> params);

    int deleteResourceByUserId(String userId);

    public int insertRelationOfUserAndResource(String userId, String ids);

    boolean checkName(String name);

    int updateLoginErrorNum(Map<String, Object> params);

    int updateUserLock();

    int deleteUser(String userId);

    /**
     * 通过userId更新白名单开启状态
     * @param map
     * @return
     */
    int updateWhiteState(Map<String, Object> map);

    /**
     * 通过roleId查询用户
     * @param roleId
     * @return
     */
    List<SYSUser> queryUserByRoleId(Long roleId);

    /**
     * 分页查询用户
     * @param param
     * @return
     */
    List<Map<String, Object>> getSYSUserListNew(Map<String, Object> param);

    /**
     * 查询用户的全部的数量
     * @param param
     * @return
     */
    int getCountNew(Map<String, Object> param);

    /**
     * 通过账号更新最后在线时间
     * @param userId
     * @return
     */
    int updateLastloginTimeByUserId(Long userId, String currentTime);

    /**
     * 通过账号查询IP白名单状态
     * @param uname
     * @return
     */
    Integer queryWhileStateByUname(String uname);

    /**
     * 重置密码
     * @param pwd
     * @param userId
     * @return
     */
    int resetPwd(String pwd, String userId);

    /**
     * 获取管理员白名单状态
     * @return
     */
    int adminWhileState();

}

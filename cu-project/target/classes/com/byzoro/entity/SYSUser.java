package com.byzoro.entity;

import java.util.List;

public class SYSUser {
    private Long userId;

    private String uname;

    private String pwd;
    
    private String phone;

    private String email;
    
    private String status;
    
    private String type;
    
    private Integer loginErrorNum;

    
    private List<SYSUserRole> userRoleList;
    
//    private List<SYSRole> roleList;

	/**
	 * 白名单开启状态 0关闭 1开启
	 */
	private Integer whiteState;

	/**
	 * 用户类型 0超级管理员 1管理员 2操作用户
	 */
	private Integer userType;
	/**
	 * 地图经度
	 */
	private String mapLng;
	/**
	 * 地图纬度
	 */
	private String mapLat;
	/**
	 * 地图级别
	 */
	private String mapLevel;
	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 最后登录时间
	 */
	private String lastLoginTime;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

	public List<SYSUserRole> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<SYSUserRole> userRoleList) {
		this.userRoleList = userRoleList;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getLoginErrorNum() {
		return loginErrorNum;
	}

	public void setLoginErrorNum(Integer loginErrorNum) {
		this.loginErrorNum = loginErrorNum;
	}

	public Integer getWhiteState() {
		return whiteState;
	}

	public void setWhiteState(Integer whiteState) {
		this.whiteState = whiteState;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getMapLng() {
		return mapLng;
	}

	public void setMapLng(String mapLng) {
		this.mapLng = mapLng;
	}

	public String getMapLat() {
		return mapLat;
	}

	public void setMapLat(String mapLat) {
		this.mapLat = mapLat;
	}

	public String getMapLevel() {
		return mapLevel;
	}

	public void setMapLevel(String mapLevel) {
		this.mapLevel = mapLevel;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
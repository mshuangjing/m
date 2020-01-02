package com.byzoro.entity;

public class SYSUserRole {
    private Long userId;

    private Long roleId;

    private SYSRole role;
    
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

	public SYSRole getRole() {
		return role;
	}

	public void setRole(SYSRole role) {
		this.role = role;
	}


}
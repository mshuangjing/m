package com.byzoro.entity;

public class SYSLog {

	private Integer id;

	private String loginName;	
	
	private String roleName;

	private String optContent;

	private String clientIp;
	
	private String createTime;

	private String beforeOperation;

	private String afterOperation;

	private String countyId;

	private String deviceCode;

	private String optName;

	private String optStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getBeforeOperation() {
		return beforeOperation;
	}

	public void setBeforeOperation(String beforeOperation) {
		this.beforeOperation = beforeOperation;
	}

	public String getAfterOperation() {
		return afterOperation;
	}

	public void setAfterOperation(String afterOperation) {
		this.afterOperation = afterOperation;
	}

	public String getCountyId() {
		return countyId;
	}

	public void setCountyId(String countyId) {
		this.countyId = countyId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getOptName() {
		return optName;
	}

	public void setOptName(String optName) {
		this.optName = optName;
	}

	public String getOptStatus() {
		return optStatus;
	}

	public void setOptStatus(String optStatus) {
		this.optStatus = optStatus;
	}
}

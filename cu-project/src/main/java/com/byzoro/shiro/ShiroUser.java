package com.byzoro.shiro;

import java.io.Serializable;

/**
 * ClassName: ShiroUser
 * Description:
 * CreateDate: 2018/7/18 23:49
 * Author: liwenhui
 * UpdateUser:
 * UpdateDate:
 * UpdateRemark:
 * Version: 1.0
 **/
public class ShiroUser implements Serializable {
	private static final long serialVersionUID = -791367504118484126L;

	private Long id;
	private String username;
	private String name;

	public ShiroUser() {
	}

	public ShiroUser(Long id, String username, String name) {
		this.id = id;
		this.username = username;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

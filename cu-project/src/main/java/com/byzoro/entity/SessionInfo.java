package com.byzoro.entity;

import java.io.Serializable;


/**
 * 此类用于存放session里面的信息
 * 
 * @author King_Qin
 * 
 */
public class SessionInfo implements Serializable{
	private static final long serialVersionUID = -2283462211313448462L;

	private Long userId;

    private String uname;

    private String pwd;
    
    public SessionInfo(){
    	
    }
    
    public SessionInfo(SYSUser user){
    	this.userId = user.getUserId();
    	this.uname = user.getUname();
    	this.pwd = user.getPwd();
    }

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
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "SessionInfo [userId=" + userId + ", uname=" + uname + ", pwd="
				+ pwd + "]";
	}
}
